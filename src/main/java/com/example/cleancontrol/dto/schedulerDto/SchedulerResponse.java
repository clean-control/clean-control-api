package com.example.cleancontrol.dto.schedulerDto;

import java.sql.Date;
import java.time.LocalDateTime;

import com.example.cleancontrol.model.Enterprise;

import lombok.Builder;
@Builder
public record SchedulerResponse(Integer id, Date date, Boolean active, Enterprise enterprise,LocalDateTime createDate, LocalDateTime updateDate) {

}