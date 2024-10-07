package com.example.cleancontrol.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
import com.example.cleancontrol.api.dto.fileDto.*;
import com.example.cleancontrol.api.service.ContentService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/api/content")
@RequiredArgsConstructor
public class ContentController {

    private final ContentService contentService;

 

    @PostMapping("/upload/image/client")
    public ResponseEntity<ImageClient> uploadImageClient(@RequestParam("file") MultipartFile file, @RequestParam("id") Integer clientId){
        try {
            FileResponse fileResponse = contentService.uploadFile(file, clientId, "client");
            ImageClient imageClient = new ImageClient(fileResponse.id(), fileResponse.name(), fileResponse.description(), fileResponse.fileExtension(), fileResponse.path(), fileResponse.fileSize(), fileResponse.client());
            return ResponseEntity.ok(imageClient);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/upload/image/employee")
    public ResponseEntity<ImageEmployee> uploadImageEmployee(@RequestParam("file") MultipartFile file, @RequestParam("id") Integer employeeId){
        try {
            FileResponse fileResponse = contentService.uploadFile(file, employeeId, "employee");
            ImageEmployee imageEmployee = new ImageEmployee(fileResponse.id(), fileResponse.name(), fileResponse.description(), fileResponse.fileExtension(), fileResponse.path(), fileResponse.fileSize(), fileResponse.employee());
            return ResponseEntity.ok(imageEmployee);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/upload/image/enterprise")
    public ResponseEntity<ImageEnterprise> uploadImageEnterprise(@RequestParam("file") MultipartFile file, @RequestParam("id") Integer enterpriseId){
        try {
            FileResponse fileResponse = contentService.uploadFile(file, enterpriseId, "enterprise");
            ImageEnterprise imageEnterprise = new ImageEnterprise(fileResponse.id(), fileResponse.name(), fileResponse.description(), fileResponse.fileExtension(), fileResponse.path(), fileResponse.fileSize(), fileResponse.enterprise());
            return ResponseEntity.ok(imageEnterprise);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/upload/image/category")
    public ResponseEntity<ImageCategory> uploadImageCategory(@RequestParam("file") MultipartFile file, @RequestParam("id") Integer categoryId){
        try {
            FileResponse fileResponse = contentService.uploadFile(file, categoryId, "category");
            ImageCategory imageCategory = new ImageCategory(fileResponse.id(), fileResponse.name(), fileResponse.description(), fileResponse.fileExtension(), fileResponse.path(), fileResponse.fileSize(), fileResponse.category());
            return ResponseEntity.ok(imageCategory);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/upload/image/product")
    public ResponseEntity<ImageProduct> uploadImageProduct(@RequestParam("file") MultipartFile file, @RequestParam("id") Integer productId){
        try {
            FileResponse fileResponse = contentService.uploadFile(file, productId, "product");
            ImageProduct imageProduct = new ImageProduct(fileResponse.id(), fileResponse.name(), fileResponse.description(), fileResponse.fileExtension(), fileResponse.path(), fileResponse.fileSize(), fileResponse.product());
            return ResponseEntity.ok(imageProduct);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


    @PostMapping("/upload/image/service")
    public ResponseEntity<ImageService> uploadImageService(@RequestParam("file") MultipartFile file, @RequestParam("id") Integer serviceId){
        try {
            FileResponse fileResponse = contentService.uploadFile(file, serviceId, "service");
            ImageService imageService = new ImageService(fileResponse.id(), fileResponse.name(), fileResponse.description(), fileResponse.fileExtension(), fileResponse.path(), fileResponse.fileSize(), fileResponse.service());
            return ResponseEntity.ok(imageService);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/upload/image/productType")
    public ResponseEntity<ImageProductType> uploadImageProductType(@RequestParam("file") MultipartFile file, @RequestParam("id") Integer productTypeId){
        try {
            FileResponse fileResponse = contentService.uploadFile(file, productTypeId, "productType");
            ImageProductType imageProductType = new ImageProductType(fileResponse.id(), fileResponse.name(), fileResponse.description(), fileResponse.fileExtension(), fileResponse.path(), fileResponse.fileSize(), fileResponse.productType());
            return ResponseEntity.ok(imageProductType);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/upload/image/serviceType")
    public ResponseEntity<ImageServiceType> uploadImageServiceType(@RequestParam("file") MultipartFile file, @RequestParam("id") Integer serviceTypeId){
        try {
            FileResponse fileResponse = contentService.uploadFile(file, serviceTypeId, "serviceType");
            ImageServiceType imageServiceType = new ImageServiceType(fileResponse.id(), fileResponse.name(), fileResponse.description(), fileResponse.fileExtension(), fileResponse.path(), fileResponse.fileSize(), fileResponse.serviceType());
            return ResponseEntity.ok(imageServiceType);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


}
