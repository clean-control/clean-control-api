package com.example.cleancontrol.dto.categoryDto;

import java.time.LocalDateTime;

import lombok.Builder;

@Builder
public record CategoryResponse(Integer id, String name, String description, String imgUrl, Boolean active,
        LocalDateTime createDate, LocalDateTime updateDate) {

}
