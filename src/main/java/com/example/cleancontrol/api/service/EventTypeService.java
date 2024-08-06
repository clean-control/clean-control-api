package com.example.cleancontrol.api.service;

import org.springframework.stereotype.Service;

import com.example.cleancontrol.api.dto.eventTypeDto.EventTypeResponse;
import com.example.cleancontrol.api.dto.eventTypeDto.EventTypeRequest;

import com.example.cleancontrol.domain.model.EventType;

import com.example.cleancontrol.domain.repository.EventTypeRepository;
import com.example.cleancontrol.api.mapper.EventTypeMapper;
import java.util.List;

import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class EventTypeService {

    private final EventTypeRepository eventTypeRepository;
    private final EventTypeMapper eventTypeMapper;

    public List<EventTypeResponse> findAll() {
        List<EventType> eventTypes = eventTypeRepository.findAll();
        return eventTypes.stream().map(eventTypeMapper::toResponse).collect(Collectors.toList());
    }

    public EventTypeResponse findById(Integer id) {
        EventType eventType = eventTypeRepository.findById(id).orElseThrow();
        return eventTypeMapper.toResponse(eventType);
    }

    public EventTypeResponse save(EventTypeRequest eventTypeRequest) {
        EventType eventType = new EventType();
        eventType.setName(eventTypeRequest.name());
        eventType.setDescription(eventTypeRequest.description());
        eventType.setActive(eventTypeRequest.active());
        eventType = eventTypeRepository.save(eventType);
        return eventTypeMapper.toResponse(eventType);
    }

    public EventTypeResponse update(Integer id, EventTypeRequest eventTypeRequest) {
        EventType eventType = eventTypeRepository.findById(id).orElseThrow();
        eventType.setName(eventTypeRequest.name());
        eventType.setDescription(eventTypeRequest.description());
        eventType.setActive(eventTypeRequest.active());
        eventType = eventTypeRepository.save(eventType);
        return eventTypeMapper.toResponse(eventType);
    }

    public void delete(Integer id) {
        eventTypeRepository.deleteById(id);
    }
}
