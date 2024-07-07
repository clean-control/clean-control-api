package com.example.cleancontrol.dto.eventServicesEnterpriseDto;

import lombok.Builder;

@Builder
public record EventServicesEnterpriseRequest(Integer eventEnterpriseId, Integer servicesId, Integer productId) {

}

