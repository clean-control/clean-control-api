package com.example.cleancontrol.api.dto.categoryDto;


import lombok.Builder;

@Builder
public record CategoryRequest(String name, String description, String imgUrl, Boolean active) {

}
