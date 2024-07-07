package com.example.cleancontrol.api.dto.eventEnterpriseDto;


import lombok.Builder;

@Builder
public record EventEnterpriseRequest( String name, String description, Boolean active, Double price, Integer enterpriseId, Integer eventTypeId) {

}
