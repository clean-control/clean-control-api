package com.example.cleancontrol.api.dto.productTypeDto;


import lombok.Builder;

@Builder
public record ProductTypeRecord(String name, String description, Integer categoryId, String imgUrl, Boolean active) {

}
