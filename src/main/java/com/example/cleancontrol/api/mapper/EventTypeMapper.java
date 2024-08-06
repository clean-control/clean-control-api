package com.example.cleancontrol.api.mapper;


import java.util.List;
import org.springframework.stereotype.Component;

import com.example.cleancontrol.domain.model.EventType;
import com.example.cleancontrol.api.dto.eventTypeDto.EventTypeResponse;
@Component
public class EventTypeMapper {


    public EventTypeResponse toResponse(EventType eventType) {
        return EventTypeResponse.builder()
                .id(eventType.getId())
                .name(eventType.getName())
                .description(eventType.getDescription())
                .active(eventType.getActive())
                .createDate(eventType.getCreateDate())
                .updateDate(eventType.getUpdateDate())
                .build();
    }

    public EventType toEntity(EventTypeResponse eventTypeResponse) {
        return EventType.builder()
                .id(eventTypeResponse.id())
                .name(eventTypeResponse.name())
                .description(eventTypeResponse.description())
                .active(eventTypeResponse.active())
                .createDate(eventTypeResponse.createDate())
                .updateDate(eventTypeResponse.updateDate())
                .build();
    }

    public List<EventTypeResponse> toResponse(List<EventType> eventTypes) {
        return eventTypes.stream().map(this::toResponse).toList();
    }

    

}
