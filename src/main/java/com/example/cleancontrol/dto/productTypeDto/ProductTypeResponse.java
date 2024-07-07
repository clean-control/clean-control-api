package com.example.cleancontrol.dto.productTypeDto;

import java.time.LocalDateTime;

import com.example.cleancontrol.model.Category;

import lombok.Builder;

@Builder
public record ProductTypeResponse(Integer id, String name, String description, Category category, String imgUrl, Boolean active, LocalDateTime createDate, LocalDateTime updateDate) {

}