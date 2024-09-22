package com.example.cleancontrol.api.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import com.example.cleancontrol.domain.repository.ServicesRepository;
import com.example.cleancontrol.domain.model.Services;
import com.example.cleancontrol.api.dto.servicesDto.ServicesRequest;

import java.util.List;


@Service
@RequiredArgsConstructor    
public class ServicesService {

    private final ServicesRepository servicesRepository;

    public List<Services> findAll() {
        List<Services> servicess = servicesRepository.findAll();
        return servicess;
    }

    public Services findById(Integer id) {
        Services services = servicesRepository.findById(id).orElseThrow();
        return services;
    }

    public Services save(ServicesRequest servicesRequest) {
        Services services = new Services();
        services.setName(servicesRequest.name());
        services.setDescription(servicesRequest.description());
        services.setPrice(servicesRequest.price());
        services.setImgUrl(servicesRequest.imgUrl());
        services.setActive(servicesRequest.active());
        services = servicesRepository.save(services);
        return services;
    }

    public Services update(Integer id, ServicesRequest servicesRequest) {
        Services services = servicesRepository.findById(id).orElseThrow();
        services.setName(servicesRequest.name());
        services.setDescription(servicesRequest.description());
        services.setPrice(servicesRequest.price());
        services.setImgUrl(servicesRequest.imgUrl());
        services.setActive(servicesRequest.active());
        services = servicesRepository.save(services);
        return services;
    }

    public void delete(Integer id) {
        servicesRepository.deleteById(id);
    }

}
