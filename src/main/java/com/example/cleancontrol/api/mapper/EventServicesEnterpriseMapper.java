package com.example.cleancontrol.api.mapper;


import java.util.List;
import org.springframework.stereotype.Component;

import com.example.cleancontrol.domain.model.EventServicesEnterprise;

import com.example.cleancontrol.api.dto.eventServicesEnterpriseDto.EventServicesEnterpriseResponse;

@Component
public class EventServicesEnterpriseMapper {

    public EventServicesEnterpriseResponse toResponse(EventServicesEnterprise eventServicesEnterprise) {
        return EventServicesEnterpriseResponse.builder()
                .id(eventServicesEnterprise.getId())
                .eventEnterprise(eventServicesEnterprise.getEventEnterprise())
                .services(eventServicesEnterprise.getServices())
                .product(eventServicesEnterprise.getProduct())
                .createDate(eventServicesEnterprise.getCreateDate())
                .updateDate(eventServicesEnterprise.getUpdateDate())
                .build();
    }


    public EventServicesEnterprise toEntity(EventServicesEnterpriseResponse eventServicesEnterpriseResponse) {
        return EventServicesEnterprise.builder()
                .id(eventServicesEnterpriseResponse.id())
                .eventEnterprise(eventServicesEnterpriseResponse.eventEnterprise())
                .services(eventServicesEnterpriseResponse.services())
                .product(eventServicesEnterpriseResponse.product())
                .createDate(eventServicesEnterpriseResponse.createDate())
                .updateDate(eventServicesEnterpriseResponse.updateDate())
                .build();
    }


    public List<EventServicesEnterpriseResponse> toResponse(List<EventServicesEnterprise> eventServicesEnterprises) {
        return eventServicesEnterprises.stream().map(this::toResponse).toList();
    }


}
