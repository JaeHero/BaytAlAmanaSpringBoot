package com.example.BaytAlAmana.controller;

import com.example.BaytAlAmana.service.GoogleDriveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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


    @PostMapping("/image-upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            String fileUrl = driveService.uploadFileToFolder(file, folderId);
            return ResponseEntity.ok(fileUrl);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Upload failed: " + e.getMessage());
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
