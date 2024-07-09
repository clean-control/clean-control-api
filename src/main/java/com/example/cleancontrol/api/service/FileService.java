package com.example.cleancontrol.api.service;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.cleancontrol.api.dto.fileDto.FileResponse;
import com.example.cleancontrol.config.FileStorageApiProperties;
import com.example.cleancontrol.domain.model.Content;
import com.example.cleancontrol.domain.repository.ContentRepository;
import lombok.RequiredArgsConstructor;

@Service
public class FileService {
    private final  Cloudinary cloudinary;

    public FileService(FileStorageApiProperties fileStorageApiProperties) {
        this.cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dzutcf8qe",
                "api_key", "167129722689288",
                "api_secret", "OeT7FMp5afVS4DY5VGvr_Z9zBAk",
                "secure", true));
    }

    public  String upload(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap("public_id", fileName));
            return (String) uploadResult.get("url");
        } catch (Exception e) {
            throw new RuntimeException("Falha ao fazer o upload do arquivo para o Cloudinary", e);
        }
    }
}
