package com.example.cleancontrol.api.service;

import org.springframework.stereotype.Service;

import com.example.cleancontrol.api.dto.eventServicesEnterpriseDto.EventServicesEnterpriseResponse;
import com.example.cleancontrol.api.dto.eventServicesEnterpriseDto.EventServicesEnterpriseRequest;
import com.example.cleancontrol.domain.model.EventServicesEnterprise;
import com.example.cleancontrol.domain.repository.EventEnterpriseRepository;
import com.example.cleancontrol.domain.repository.EventServicesEnterpriseRepository;
import com.example.cleancontrol.domain.repository.ProductRepository;
import com.example.cleancontrol.domain.repository.ServicesRepository;

import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

import com.example.cleancontrol.api.mapper.EventServicesEnterpriseMapper;


@Service
@RequiredArgsConstructor
public class EventServicesEnterpriseService {

    private final EventServicesEnterpriseRepository eventServicesEnterpriseRepository;
    private final EventServicesEnterpriseMapper eventServicesEnterpriseMapper;
    private final ProductRepository productRepository;
    private final ServicesRepository servicesRepository;
    private final EventEnterpriseRepository eventEnterpriseRepository;

    public List<EventServicesEnterpriseResponse> findAll() {
        List<EventServicesEnterprise> eventServicesEnterprises = eventServicesEnterpriseRepository.findAll();
        return eventServicesEnterprises.stream().map(eventServicesEnterpriseMapper::toResponse).collect(Collectors.toList());
    }

    public EventServicesEnterpriseResponse findById(Integer id) {
        EventServicesEnterprise eventServicesEnterprise = eventServicesEnterpriseRepository.findById(id).orElseThrow();
        return eventServicesEnterpriseMapper.toResponse(eventServicesEnterprise);
    }

    public EventServicesEnterpriseResponse save(EventServicesEnterpriseRequest eventServicesEnterpriseRequest) {
        EventServicesEnterprise eventServicesEnterprise = new EventServicesEnterprise();
        eventServicesEnterprise.setProduct(productRepository.findById(eventServicesEnterpriseRequest.productId()).orElse(null));
        eventServicesEnterprise.setServices(servicesRepository.findById(eventServicesEnterpriseRequest.servicesId()).orElse(null));
        eventServicesEnterprise.setEventEnterprise(eventEnterpriseRepository.findById(eventServicesEnterpriseRequest.eventEnterpriseId()).orElse(null));

        eventServicesEnterprise = eventServicesEnterpriseRepository.save(eventServicesEnterprise);

        return eventServicesEnterpriseMapper.toResponse(eventServicesEnterprise);

    }

    public EventServicesEnterpriseResponse update(Integer id, EventServicesEnterpriseRequest eventServicesEnterpriseRequest) {
        EventServicesEnterprise eventServicesEnterprise = eventServicesEnterpriseRepository.findById(id).orElseThrow();
        eventServicesEnterprise.setProduct(productRepository.findById(eventServicesEnterpriseRequest.productId()).orElse(null));
        eventServicesEnterprise.setServices(servicesRepository.findById(eventServicesEnterpriseRequest.servicesId()).orElse(null));
        eventServicesEnterprise.setEventEnterprise(eventEnterpriseRepository.findById(eventServicesEnterpriseRequest.eventEnterpriseId()).orElse(null));

        eventServicesEnterprise = eventServicesEnterpriseRepository.save(eventServicesEnterprise);

        return eventServicesEnterpriseMapper.toResponse(eventServicesEnterprise);
    }

    public void delete(Integer id) {
        eventServicesEnterpriseRepository.deleteById(id);
    }


    
}
