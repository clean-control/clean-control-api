package com.example.cleancontrol.api.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.cleancontrol.domain.model.ProductType;
import com.example.cleancontrol.api.dto.productTypeDto.ProductTypeResponse;




@Component
public class ProductTypeMapper {

    public ProductTypeResponse toResponse(ProductType productType) {
        return ProductTypeResponse.builder()
                .id(productType.getId())
                .name(productType.getName())
                .description(productType.getDescription())
                .active(productType.getActive())
                .createDate(productType.getCreateDate())
                .updateDate(productType.getUpdateDate())
                .build();
    }

    public ProductType toEntity(ProductTypeResponse productTypeResponse) {
        return ProductType.builder()
                .id(productTypeResponse.id())
                .name(productTypeResponse.name())
                .description(productTypeResponse.description())
                .active(productTypeResponse.active())
                .createDate(productTypeResponse.createDate())
                .updateDate(productTypeResponse.updateDate())
                .build();
    }

    public List<ProductTypeResponse> toResponse(List<ProductType> productTypes) {
        return productTypes.stream().map(this::toResponse).toList();
    }

}
