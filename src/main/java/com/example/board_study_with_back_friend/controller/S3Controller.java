package com.example.board_study_with_back_friend.controller;

import com.example.board_study_with_back_friend.service.S3UploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
public class S3Controller {
    @Value("${cloud.aws.s3.bucket}")
    private String bucket; // S3 버킷 이름

    private final S3UploadService s3UploadService;

    @PostMapping("/image")
    public ResponseEntity<String> updateUserImage(@RequestParam("images") MultipartFile multipartFile) {
        try {
            String uploadUrl = s3UploadService.uploadFiles(multipartFile, "va/");
            return ResponseEntity.ok(uploadUrl);
        } catch (Exception e) {
            return ResponseEntity.ok("이미지 업로드 실패: " +e.getMessage());
        }
    }

    @PostMapping("/images")
    public ResponseEntity<String> updateUserImages(@RequestParam("images") MultipartFile[] multipartFiles) {
        StringBuilder uploadUrls = new StringBuilder();
        try {
            for (MultipartFile multipartFile : multipartFiles) {
                String uploadUrl = s3UploadService.uploadFiles(multipartFile, "va/");
                uploadUrls.append(uploadUrl).append("\n");
            }
        } catch (Exception e) {
            return ResponseEntity.ok("이미지 업로드 실패: " + e.getMessage());
        }
        return ResponseEntity.ok(uploadUrls.toString());
    }
}
