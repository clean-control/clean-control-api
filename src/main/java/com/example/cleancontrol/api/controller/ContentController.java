package com.example.cleancontrol.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.cleancontrol.api.dto.fileDto.images.ImageCategory;
import com.example.cleancontrol.api.dto.fileDto.images.ImageClient;
import com.example.cleancontrol.api.dto.fileDto.images.ImageEmployee;
import com.example.cleancontrol.api.dto.fileDto.images.ImageEnterprise;
import com.example.cleancontrol.api.dto.fileDto.images.ImageProduct;
import com.example.cleancontrol.api.dto.fileDto.images.ImageProductType;
import com.example.cleancontrol.api.dto.fileDto.images.ImageService;
import com.example.cleancontrol.api.dto.fileDto.images.ImageServiceType;
import com.example.cleancontrol.api.mapper.ContentMapper;
import com.example.cleancontrol.api.dto.fileDto.*;
import com.example.cleancontrol.api.service.ContentService;
import com.example.cleancontrol.domain.model.Content;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/api/content")
@RequiredArgsConstructor
public class ContentController {

    private final ContentService contentService;

    @PostMapping("/upload/image/client")
    public ResponseEntity<ImageClient> uploadImageClient(@RequestParam("file") MultipartFile file,
            @RequestParam("id") Integer clientId) {
        try {
            FileResponse fileResponse = contentService.uploadFile(file, clientId, "client");

            return ResponseEntity.ok((ImageClient) ContentMapper.toResponse(fileResponse, "client"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/upload/image/employee")
    public ResponseEntity<ImageEmployee> uploadImageEmployee(@RequestParam("file") MultipartFile file,
            @RequestParam("id") Integer employeeId) {
        try {
            FileResponse fileResponse = contentService.uploadFile(file, employeeId, "employee");
           
            return ResponseEntity.ok((ImageEmployee) ContentMapper.toResponse(fileResponse, "employee"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/upload/image/enterprise")
    public ResponseEntity<ImageEnterprise> uploadImageEnterprise(@RequestParam("file") MultipartFile file,
            @RequestParam("id") Integer enterpriseId) {
        try {
            FileResponse fileResponse = contentService.uploadFile(file, enterpriseId, "enterprise");
           
            return ResponseEntity.ok((ImageEnterprise) ContentMapper.toResponse(fileResponse, "enterprise"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/upload/image/category")
    public ResponseEntity<ImageCategory> uploadImageCategory(@RequestParam("file") MultipartFile file,
            @RequestParam("id") Integer categoryId) {
        try {
            FileResponse fileResponse = contentService.uploadFile(file, categoryId, "category");
           
            return ResponseEntity.ok((ImageCategory) ContentMapper.toResponse(fileResponse, "category"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/upload/image/product")
    public ResponseEntity<ImageProduct> uploadImageProduct(@RequestParam("file") MultipartFile file,
            @RequestParam("id") Integer productId) {
        try {
            FileResponse fileResponse = contentService.uploadFile(file, productId, "product");
          
            return ResponseEntity.ok((ImageProduct) ContentMapper.toResponse(fileResponse, "product"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/upload/image/service")
    public ResponseEntity<ImageService> uploadImageService(@RequestParam("file") MultipartFile file,
            @RequestParam("id") Integer serviceId) {
        try {
            FileResponse fileResponse = contentService.uploadFile(file, serviceId, "service");
         
            return ResponseEntity.ok((ImageService) ContentMapper.toResponse(fileResponse, "service"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/upload/image/productType")
    public ResponseEntity<ImageProductType> uploadImageProductType(@RequestParam("file") MultipartFile file,
            @RequestParam("id") Integer productTypeId) {
        try {
            FileResponse fileResponse = contentService.uploadFile(file, productTypeId, "productType");
            
            return ResponseEntity.ok((ImageProductType) ContentMapper.toResponse(fileResponse, "productType"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/upload/image/serviceType")
    public ResponseEntity<ImageServiceType> uploadImageServiceType(@RequestParam("file") MultipartFile file,
            @RequestParam("id") Integer serviceTypeId) {
        try {
            FileResponse fileResponse = contentService.uploadFile(file, serviceTypeId, "serviceType");
            
            return ResponseEntity.ok((ImageServiceType) ContentMapper.toResponse(fileResponse, "serviceType"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/imageAll")
    public ResponseEntity<List<FileResponse>> getImageAll() {
        try {
            List<FileResponse> fileResponse = new ArrayList<>();

            for (Content content : contentService.findAll()) {
                fileResponse.add(new FileResponse(content.getId(), content.getName(), content.getDescription(),
                        content.getFileExtension(), content.getPath(), content.getFileSize(), content.getClient(),
                        content.getEmployee(), content.getEnterprise(), content.getCategory(), content.getProduct(),
                        content.getService(), content.getProductType(), content.getServiceType(),
                        content.getCreateDate(), content.getUpdateDate()));
            }
            return ResponseEntity.ok(fileResponse);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
