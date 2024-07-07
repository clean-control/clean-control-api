package com.example.cleancontrol.dto.schedulerTypeDto;

import lombok.Builder;

@Builder
public record SchedulerTypeRequest(String name, String description) {

}
