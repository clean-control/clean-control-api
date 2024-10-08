package com.example.cleancontrol.api.dto.productDto;

import java.time.LocalDateTime;

import com.example.cleancontrol.domain.model.Enterprise;
import com.example.cleancontrol.domain.model.ProductType;

import lombok.Builder;

@Builder
public record ProductResponse(Integer id, String name, String description, Double price, String imgUrl,
        Integer qtdStock,
        Enterprise enterprise,
        ProductType productType,
        Boolean active, LocalDateTime createDate, LocalDateTime updateDate) {

}