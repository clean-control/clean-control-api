package com.example.cleancontrol.api.dto.eventEnterpriseDto;

import java.time.LocalDateTime;

import com.example.cleancontrol.domain.model.Enterprise;
import com.example.cleancontrol.domain.model.EventType;

import lombok.Builder;

@Builder
public record EventEnterpriseResponse(Integer id, String name, String description, Boolean active, Double price, Enterprise enterprise, EventType eventType,
        LocalDateTime createDate, LocalDateTime updateDate) {

}