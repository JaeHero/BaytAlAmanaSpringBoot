package com.example.BaytAlAmana.controller;

import com.example.BaytAlAmana.service.GoogleDriveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/files")
@CrossOrigin(origins = "*")
public class GoogleDriveController {
    @Autowired
    GoogleDriveService driveService;

    @Value("${google.drive.folder-id}")
    private String folderId;


    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            String fileUrl = driveService.uploadFileToFolder(file, folderId);
            return ResponseEntity.ok(fileUrl);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Upload failed: " + e.getMessage());
        }
    }

    @GetMapping("/test-drive")
    public ResponseEntity<?> testGoogleDriveConnection() {
        try {
            List<String> files = driveService.listFiles();
            return ResponseEntity.ok(files);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Google Drive connection failed: " + e.getMessage());
        }
    }

}
