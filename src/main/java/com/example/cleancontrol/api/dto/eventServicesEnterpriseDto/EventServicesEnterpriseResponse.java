package com.example.cleancontrol.api.dto.eventServicesEnterpriseDto;

import java.time.LocalDateTime;

import lombok.Builder;

@Builder
public record EventServicesEnterpriseResponse(Integer id, Integer eventEnterpriseId, Integer servicesId, Integer productId, LocalDateTime createDate, LocalDateTime updateDate) {

}