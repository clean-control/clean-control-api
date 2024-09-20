package com.example.cleancontrol.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.cleancontrol.api.dto.eventTypeDto.EventTypeRequest;
import com.example.cleancontrol.domain.model.EventType;
import com.example.cleancontrol.domain.repository.EventTypeRepository;

import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class EventTypeService {

    private final EventTypeRepository eventTypeRepository;

    public List<EventType> findAll() {
        List<EventType> eventTypes = eventTypeRepository.findAll();
        return eventTypes;
    }

    public EventType findById(Integer id) {
        EventType eventType = eventTypeRepository.findById(id).orElseThrow();
        return eventType;
    }

    public EventType save(EventTypeRequest eventTypeRequest) {
        EventType eventType = new EventType();
        eventType.setName(eventTypeRequest.name());
        eventType.setDescription(eventTypeRequest.description());
        eventType.setActive(eventTypeRequest.active());
        eventType = eventTypeRepository.save(eventType);
        return eventType;
    }

    public EventType update(Integer id, EventTypeRequest eventTypeRequest) {
        EventType eventType = eventTypeRepository.findById(id).orElseThrow();
        eventType.setName(eventTypeRequest.name());
        eventType.setDescription(eventTypeRequest.description());
        eventType.setActive(eventTypeRequest.active());
        eventType = eventTypeRepository.save(eventType);
        return eventType;
    }

    public void delete(Integer id) {
        eventTypeRepository.deleteById(id);
    }
}
