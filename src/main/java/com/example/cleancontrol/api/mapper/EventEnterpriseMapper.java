package com.example.cleancontrol.api.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.cleancontrol.domain.model.EventEnterprise;
import com.example.cleancontrol.api.dto.eventEnterpriseDto.EventEnterpriseResponse;

@Component
public class EventEnterpriseMapper {

    public EventEnterpriseResponse toResponse(EventEnterprise eventEnterprise) {
        return EventEnterpriseResponse.builder()
                .id(eventEnterprise.getId())
                .name(eventEnterprise.getName())
                .description(eventEnterprise.getDescription())
                .active(eventEnterprise.getActive())
                .price(eventEnterprise.getPrice())
                .createDate(eventEnterprise.getCreateDate())
                .updateDate(eventEnterprise.getUpdateDate())
                .enterprise(eventEnterprise.getEnterprise())
                .eventType(eventEnterprise.getEventType())
                .build();
    }


    public EventEnterprise toEntity(EventEnterpriseResponse eventEnterpriseResponse) {
        return EventEnterprise.builder()
                .id(eventEnterpriseResponse.id())
                .name(eventEnterpriseResponse.name())
                .description(eventEnterpriseResponse.description())
                .active(eventEnterpriseResponse.active())
                .price(eventEnterpriseResponse.price())
                .createDate(eventEnterpriseResponse.createDate())
                .updateDate(eventEnterpriseResponse.updateDate())
                .enterprise(eventEnterpriseResponse.enterprise())
                .eventType(eventEnterpriseResponse.eventType())
                .build();
    }


    public List<EventEnterpriseResponse> toResponse(List<EventEnterprise> eventEnterprises) {
        return eventEnterprises.stream().map(this::toResponse).toList();
    }



}
