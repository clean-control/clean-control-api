package com.example.cleancontrol.dto.serviceTypeDto;

import java.time.LocalDateTime;

import com.example.cleancontrol.model.Category;

import lombok.Builder;
@Builder
public record ServiceTypeResponse(Integer id, String name, String description, Category category, String imgUrl, Boolean active, LocalDateTime createDate, LocalDateTime updateDate) {

}
