package com.example.cleancontrol.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.cleancontrol.api.dto.eventEnterpriseDto.EventEnterpriseRequest;
import com.example.cleancontrol.domain.model.Enterprise;
import com.example.cleancontrol.domain.model.EventEnterprise;
import com.example.cleancontrol.domain.repository.EnterpriseRepository;
import com.example.cleancontrol.domain.repository.EventEnterpriseRepository;
import com.example.cleancontrol.domain.repository.EventTypeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventEnterpriseService {


    private final EventEnterpriseRepository eventEnterpriseRepository;
    private final EnterpriseRepository enterpriseRepository;
    private final EventTypeRepository   eventTypeRepository;

   
    public List<EventEnterprise> findAll() {
        List<EventEnterprise> eventEnterprises = eventEnterpriseRepository.findAll();
        return eventEnterprises;
    }

    public EventEnterprise findById(Integer id) {
        EventEnterprise eventEnterprise = eventEnterpriseRepository.findById(id).orElseThrow();
        return eventEnterprise;
    }

    public EventEnterprise save(EventEnterpriseRequest eventEnterpriseRequest) {
        EventEnterprise eventEnterprise = new EventEnterprise();

Enterprise enterprise = enterpriseRepository.findById(eventEnterpriseRequest.enterpriseId()).orElse(null);
        eventEnterprise.setName(eventEnterpriseRequest.name());
        eventEnterprise.setDescription(eventEnterpriseRequest.description());
        eventEnterprise.setActive(eventEnterpriseRequest.active());
        eventEnterprise.setPrice(eventEnterpriseRequest.price());
        eventEnterprise.setEnterprise(enterprise);
        eventEnterprise.setEventType(eventTypeRepository.findById(eventEnterpriseRequest.eventTypeId()).orElse(null));
        eventEnterprise = eventEnterpriseRepository.save(eventEnterprise);
        return eventEnterprise;

    }


    public EventEnterprise update(Integer id, EventEnterpriseRequest eventEnterpriseRequest) {
        EventEnterprise eventEnterprise = eventEnterpriseRepository.findById(id).orElseThrow();
        Enterprise enterprise = enterpriseRepository.findById(eventEnterpriseRequest.enterpriseId()).orElse(null);
        eventEnterprise.setName(eventEnterpriseRequest.name());
        eventEnterprise.setDescription(eventEnterpriseRequest.description());
        eventEnterprise.setActive(eventEnterpriseRequest.active());
        eventEnterprise.setPrice(eventEnterpriseRequest.price());
        eventEnterprise.setEnterprise(enterprise);
        eventEnterprise.setEventType(eventTypeRepository.findById(eventEnterpriseRequest.eventTypeId()).orElse(null));
        eventEnterprise = eventEnterpriseRepository.save(eventEnterprise);
        return eventEnterprise;
    }

    public void delete(Integer id) {
        eventEnterpriseRepository.deleteById(id);
    }

}
