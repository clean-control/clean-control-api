package com.example.cleancontrol.api.dto.productTypeDto;

import java.time.LocalDateTime;

import com.example.cleancontrol.domain.model.Category;

import lombok.Builder;

@Builder
public record ProductTypeResponse(Integer id, String name, String description, Category category, String imgUrl, Boolean active, LocalDateTime createDate, LocalDateTime updateDate) {

}