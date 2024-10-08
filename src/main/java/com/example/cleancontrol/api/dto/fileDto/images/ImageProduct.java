package com.example.cleancontrol.api.dto.fileDto.images;

import com.example.cleancontrol.domain.model.Product;

import lombok.Builder;

@Builder
public record ImageProduct(Integer id, String name, String description, String fileExtension, String path,Double fileSize, Product product) {

}
