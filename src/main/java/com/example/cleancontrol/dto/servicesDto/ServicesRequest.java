package com.example.cleancontrol.dto.servicesDto;

import lombok.Builder;

@Builder
public record ServicesRequest( String name, String description, Double price, String imgUrl, Boolean active, Integer enterpriseId, Integer serviceTypeId) {

}
