package com.example.BaytAlAmana.service;

import com.google.api.client.http.FileContent;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.*;
import com.google.api.services.drive.model.File;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.GoogleCredentials;
import jakarta.annotation.PostConstruct;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GoogleDriveService {

    private Drive driveService;

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

    public String uploadFileToFolder(MultipartFile multipartFile, String folderId) throws IOException {
        File fileMetadata = new File();
        fileMetadata.setName(multipartFile.getOriginalFilename());
        fileMetadata.setParents(Collections.singletonList(folderId)); // 📁 Set target folder

        java.io.File tempFile = convert(multipartFile);
        FileContent mediaContent = new FileContent(multipartFile.getContentType(), tempFile);

        File uploadedFile = driveService.files().create(fileMetadata, mediaContent)
                .setFields("id")
                .execute();

        // Make file public
        Permission permission = new Permission()
                .setType("anyone")
                .setRole("reader");
        driveService.permissions().create(uploadedFile.getId(), permission).execute();

        return "https://drive.google.com/uc?id=" + uploadedFile.getId();
    }

    private java.io.File convert(MultipartFile file) throws IOException {
        java.io.File convFile = new java.io.File(System.getProperty("java.io.tmpdir") + "/" + file.getOriginalFilename());
        file.transferTo(convFile);
        return convFile;
    }
    public List<String> listFiles() throws IOException {
        FileList result = driveService.files().list()
                .setPageSize(10)
                .setFields("files(id, name)")
                .execute();

        List<String> fileNames = new ArrayList<>();
        for (com.google.api.services.drive.model.File file : result.getFiles()) {
            fileNames.add(file.getName() + " (ID: " + file.getId() + ")");
        }

        return fileNames;
    }

}
