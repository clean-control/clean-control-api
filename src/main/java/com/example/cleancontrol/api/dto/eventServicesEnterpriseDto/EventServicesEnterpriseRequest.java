package com.example.cleancontrol.api.dto.eventServicesEnterpriseDto;

import lombok.Builder;

@Builder
public record EventServicesEnterpriseRequest(Integer eventEnterpriseId, Integer servicesId, Integer productId) {

}

