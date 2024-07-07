package com.example.cleancontrol.api.dto.eventTypeDto;

import lombok.Builder;

@Builder
public record EventTypeRequest(String name, String description, Boolean active) {

}
