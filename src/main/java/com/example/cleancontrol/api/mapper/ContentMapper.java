package com.example.cleancontrol.api.mapper;

import org.springframework.stereotype.Component;

import com.example.cleancontrol.domain.model.Content;
import com.example.cleancontrol.api.dto.fileDto.FileResponse;
import com.example.cleancontrol.api.dto.fileDto.images.*;

@Component
public class ContentMapper {

    public static Object toResponse(FileResponse content, String type) {

        switch (type) {

            case "ImageCategory":
                return ImageCategory.builder()
                        .id(content.id())
                        .name(content.name())
                        .description(content.description())
                        .fileExtension(content.fileExtension())
                        .path(content.path())
                        .fileSize(content.fileSize())
                        .category(content.category())
                        .build();

            case "ImageClient":

                return ImageClient.builder()
                        .id(content.id())
                        .name(content.name())
                        .description(content.description())
                        .fileExtension(content.fileExtension())
                        .path(content.path())
                        .fileSize(content.fileSize())
                        .client(content.client())
                        .build();

            case "ImageEmployee":

                return ImageEmployee.builder()
                        .id(content.id())
                        .name(content.name())
                        .description(content.description())
                        .fileExtension(content.fileExtension())
                        .path(content.path())
                        .fileSize(content.fileSize())
                        .employee(content.employee())
                        .build();

            case "ImageProduct":

                return ImageProduct.builder()
                        .id(content.id())
                        .name(content.name())
                        .description(content.description())
                        .fileExtension(content.fileExtension())
                        .path(content.path())
                        .fileSize(content.fileSize())
                        .product(content.product())
                        .build();

            case "ImageService":

                return ImageService.builder()
                        .id(content.id())
                        .name(content.name())
                        .description(content.description())
                        .fileExtension(content.fileExtension())
                        .path(content.path())
                        .fileSize(content.fileSize())
                        .service(content.service())
                        .build();

            case "ImageEnterprise":

                return ImageEnterprise.builder()
                        .id(content.id())
                        .name(content.name())
                        .description(content.description())
                        .fileExtension(content.fileExtension())
                        .path(content.path())
                        .fileSize(content.fileSize())
                        .enterprise(content.enterprise())
                        .build();

            case "ImageProductType":

                return ImageProductType.builder()

                        .id(content.id())
                        .name(content.name())
                        .description(content.description())
                        .fileExtension(content.fileExtension())
                        .path(content.path())
                        .fileSize(content.fileSize())
                        .productType(content.productType())
                        .build();

            case "ImageServiceType":

                return ImageServiceType.builder()
                        .id(content.id())
                        .name(content.name())
                        .description(content.description())
                        .fileExtension(content.fileExtension())
                        .path(content.path())
                        .fileSize(content.fileSize())
                        .serviceType(content.serviceType())
                        .build();

            default:
                break;
        }

        return null;
    }

}
