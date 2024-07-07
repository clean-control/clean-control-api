package com.example.cleancontrol.dto.eventEnterpriseDto;

import java.time.LocalDateTime;

import com.example.cleancontrol.model.Enterprise;
import com.example.cleancontrol.model.EventType;

import lombok.Builder;

@Builder
public record EventEnterpriseResponse(Integer id, String name, String description, Boolean active, Double price, Enterprise enterprise, EventType eventType,
        LocalDateTime createDate, LocalDateTime updateDate) {

}