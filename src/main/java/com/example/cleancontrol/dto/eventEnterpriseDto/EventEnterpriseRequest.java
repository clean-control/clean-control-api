package com.example.cleancontrol.dto.eventEnterpriseDto;


import lombok.Builder;

@Builder
public record EventEnterpriseRequest( String name, String description, Boolean active, Double price, Integer enterpriseId, Integer eventTypeId) {

}
