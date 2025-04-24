package com.example.BaytAlAmana.service;

import com.example.BaytAlAmana.dto.InvestmentImagesDTO;
import com.google.api.client.http.FileContent;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.*;
import com.google.api.services.drive.model.File;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.GoogleCredentials;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

@Service
public class GoogleDriveService {

    private Drive driveService;

    @Autowired
    private InvestmentImagesService investmentImagesService;

    @PostConstruct
    public void init() throws Exception {
        InputStream in = new ClassPathResource("credentials.json").getInputStream();
        GoogleCredentials credentials = GoogleCredentials.fromStream(in)
                .createScoped(Collections.singleton("https://www.googleapis.com/auth/drive"));

        driveService = new Drive.Builder(
                com.google.api.client.googleapis.javanet.GoogleNetHttpTransport.newTrustedTransport(),
                com.google.api.client.json.jackson2.JacksonFactory.getDefaultInstance(),
                new HttpCredentialsAdapter(credentials)
        ).setApplicationName("SpringBootDriveUploader").build();
    }

    public String uploadFileToFolder(MultipartFile multipartFile, String folderId, int investmentId) throws IOException {
        File fileMetadata = new File();
        fileMetadata.setName(multipartFile.getOriginalFilename());
        fileMetadata.setParents(Collections.singletonList(folderId));

        java.io.File tempFile = convert(multipartFile);
        FileContent mediaContent = new FileContent(multipartFile.getContentType(), tempFile);

        File uploadedFile = driveService.files().create(fileMetadata, mediaContent)
                .setFields("id, name, thumbnailLink, webContentLink")
                .execute();

        // Make file public
        Permission permission = new Permission()
                .setType("anyone")
                .setRole("reader");
        driveService.permissions().create(uploadedFile.getId(), permission).execute();

        // Use thumbnail if available, otherwise fallback to webContentLink
        String url = uploadedFile.getThumbnailLink() != null
                ? uploadedFile.getThumbnailLink()
                : uploadedFile.getWebContentLink();

        // Add image metadata to DB
        InvestmentImagesDTO investmentImagesDTO = new InvestmentImagesDTO();
        investmentImagesDTO.setInvestmentId(investmentId);
        investmentImagesDTO.setURL(uploadedFile.getId());
        investmentImagesDTO.setTitle(multipartFile.getOriginalFilename());
        investmentImagesDTO.setCreationDate(LocalDate.now());
        investmentImagesService.createInvestmentImage(investmentImagesDTO);

        return url;
    }

    private java.io.File convert(MultipartFile file) throws IOException {
        java.io.File convFile = new java.io.File(System.getProperty("java.io.tmpdir") + "/" + file.getOriginalFilename());
        file.transferTo(convFile);
        return convFile;
    }

    public List<Map<String, String>> listFilesInFolder(String folderId) throws IOException {
        FileList result = driveService.files().list()
                .setQ(String.format("'%s' in parents and trashed = false", folderId))
                .setPageSize(20)
                .setFields("files(id, name, mimeType, thumbnailLink, webContentLink)")
                .execute();

        List<Map<String, String>> files = new ArrayList<>();

        for (File file : result.getFiles()) {
            if ("application/vnd.google-apps.folder".equals(file.getMimeType())) continue;

            Map<String, String> fileData = new HashMap<>();
            fileData.put("name", file.getName());
            fileData.put("id", file.getId());

            String url = file.getThumbnailLink() != null
                    ? file.getThumbnailLink()
                    : file.getWebContentLink();

            fileData.put("url", url);
            files.add(fileData);
        }

        return files;
    }
}
