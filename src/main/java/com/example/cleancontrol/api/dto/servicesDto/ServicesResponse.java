package com.example.cleancontrol.api.dto.servicesDto;

import java.time.LocalDateTime;

import com.example.cleancontrol.domain.model.Enterprise;
import com.example.cleancontrol.domain.model.ServiceType;

import lombok.Builder;
@Builder
public record ServicesResponse(Integer id, String name, String description, Double price, String imgUrl, Boolean active, Enterprise enterprise, ServiceType serviceType, LocalDateTime createDate, LocalDateTime updateDate) {

}