package com.example.cleancontrol.dto.productDto;

import lombok.Builder;

@Builder
public record ProductRequest(String name, String description, Double price, String imgUrl, Integer qtdStock,
        Integer enterpriseId,
        Integer productTypeId,
        Boolean active) {

}
