package com.example.cleancontrol.dto.schedulerTypeDto;

import java.time.LocalDateTime;

import lombok.Builder;
@Builder
public record SchedulerTypeResponse(Integer id, String name, String description, LocalDateTime createDate, LocalDateTime updateDate) {

}