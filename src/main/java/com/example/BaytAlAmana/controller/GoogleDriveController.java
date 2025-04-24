package com.example.BaytAlAmana.controller;

import com.example.BaytAlAmana.service.GoogleDriveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/baytalamana")
@CrossOrigin(origins = "*")
public class GoogleDriveController {
    @Autowired
    GoogleDriveService driveService;

    @Value("${google.drive.folder-id}")
    private String folderId;


    @PostMapping("/upload-images/{id}")
    public ResponseEntity<List<String>> uploadMultipleFiles(@PathVariable int id, @RequestParam("files") MultipartFile[] files) {
        List<String> urls = new ArrayList<>();

        try {
            for (MultipartFile file : files) {
                String url = driveService.uploadFileToFolder(file, folderId, id);
                urls.add(url);
            }
            return ResponseEntity.ok(urls);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(List.of("Upload failed: " + e.getMessage()));
        }
    }


    @GetMapping("/images")
    public ResponseEntity<?> listFiles() {
        try {
            List<Map<String, String>> files = driveService.listFilesInFolder(folderId);
            return ResponseEntity.ok(files);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to list files: " + e.getMessage());
        }
    }

}
