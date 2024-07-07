package com.example.cleancontrol.api.dto.schedulerDto;

import java.sql.Date;


import lombok.Builder;
@Builder
public record SchedulerRequest(Date date, Boolean active, Integer enterpriseId) {

}
