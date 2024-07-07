package com.example.cleancontrol.api.dto.eventTypeDto;

import java.time.LocalDateTime;

import lombok.Builder;

@Builder
public record EventTypeResponse(Integer id, String name, String description, Boolean active, LocalDateTime createDate,
        LocalDateTime updateDate) {

}