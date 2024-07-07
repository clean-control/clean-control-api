package com.example.cleancontrol.dto.serviceTypeDto;

import lombok.Builder;

@Builder
public record ServiceTypeRequest(String name, String description, Integer categoryId, String imgUrl, Boolean active) {

}
