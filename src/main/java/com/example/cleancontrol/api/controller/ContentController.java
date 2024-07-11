package com.example.cleancontrol.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.cleancontrol.api.dto.fileDto.FileResponse;
import com.example.cleancontrol.api.service.ContentService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/api/content")
@RequiredArgsConstructor
public class ContentController {

    private final ContentService contentService;

    @PostMapping("/upload")
    public ResponseEntity<FileResponse> uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("userId") Integer userId, @RequestParam("type") String type){

       try {
           FileResponse fileResponse = contentService.uploadFile(file, userId, type);
           return ResponseEntity.ok(fileResponse);
       } catch (Exception e) {
           return ResponseEntity.badRequest().build();
       }
        
    }
}
