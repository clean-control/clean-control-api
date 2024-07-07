package com.example.cleancontrol.dto.eventTypeDto;

import lombok.Builder;

@Builder
public record EventTypeRequest(String name, String description, Boolean active) {

}
