package com.example.cleancontrol.api.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.cleancontrol.config.FileStorageApiProperties;

@Service
public class FileService {
    private final  Cloudinary cloudinary;
    private final List<String> allowedExtensions = List.of("jpg", "jpeg", "png", "gif", "webp");

    public FileService(
        @Value("${cloudinary.cloud_name}") String cloudName,
        @Value("${cloudinary.api_key}") String apiKey,
        @Value("${cloudinary.api_secret}") String apiSecret
    ) {
        this.cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", cloudName,
                "api_key", apiKey,
                "api_secret", apiSecret,
                "secure", true
        ));
    }

    public  String upload(MultipartFile file) {
        String fileExtension = StringUtils.getFilenameExtension(file.getOriginalFilename());

        if (!allowedExtensions.contains(fileExtension)) {
            throw new RuntimeException("Extensão de arquivo não permitida");
        }


        String fileName = file.getOriginalFilename().replace("." + fileExtension, "") ;
        try {
            @SuppressWarnings("rawtypes")
            Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap("public_id", fileName));
            return (String) uploadResult.get("url");
        } catch (Exception e) {
            throw new RuntimeException("Falha ao fazer o upload do arquivo para o Cloudinary", e);
        }
    }
}
