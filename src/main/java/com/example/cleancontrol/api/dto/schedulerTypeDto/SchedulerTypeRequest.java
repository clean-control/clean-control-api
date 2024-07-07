package com.example.cleancontrol.api.dto.schedulerTypeDto;

import lombok.Builder;

@Builder
public record SchedulerTypeRequest(String name, String description) {

}
