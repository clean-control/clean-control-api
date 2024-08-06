package com.example.cleancontrol.api.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.cleancontrol.domain.model.Product;
import com.example.cleancontrol.api.dto.productDto.ProductResponse;


@Component
public class ProductMapper {

    public ProductResponse toResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .active(product.getActive())
                .price(product.getPrice())
                .createDate(product.getCreateDate())
                .updateDate(product.getUpdateDate())
                .build();
    }


    public Product toEntity(ProductResponse productResponse) {
        return Product.builder()
                .id(productResponse.id())
                .name(productResponse.name())
                .description(productResponse.description())
                .active(productResponse.active())
                .price(productResponse.price())
                .createDate(productResponse.createDate())
                .updateDate(productResponse.updateDate())
                .build();
    }


    public List<ProductResponse> toResponse(List<Product> products) {
        return products.stream().map(this::toResponse).toList();
    }

}
