package com.example.cleancontrol.api.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import com.example.cleancontrol.domain.repository.ServicesRepository;
import com.example.cleancontrol.domain.model.Services;
import com.example.cleancontrol.api.mapper.ServicesMapper;
import com.example.cleancontrol.api.dto.servicesDto.ServicesRequest;
import com.example.cleancontrol.api.dto.servicesDto.ServicesResponse;

import java.util.List;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor    
public class ServicesService {

    private final ServicesRepository servicesRepository;
    private final ServicesMapper servicesMapper;

    public List<ServicesResponse> findAll() {
        List<Services> servicess = servicesRepository.findAll();
        return servicess.stream().map(servicesMapper::toResponse).collect(Collectors.toList());
    }

    public ServicesResponse findById(Integer id) {
        Services services = servicesRepository.findById(id).orElseThrow();
        return servicesMapper.toResponse(services);
    }

    public ServicesResponse save(ServicesRequest servicesRequest) {
        Services services = new Services();
        services.setName(servicesRequest.name());
        services.setDescription(servicesRequest.description());
        services.setPrice(servicesRequest.price());
        services.setImgUrl(servicesRequest.imgUrl());
        services.setActive(servicesRequest.active());
        services = servicesRepository.save(services);
        return servicesMapper.toResponse(services);
    }

    public ServicesResponse update(Integer id, ServicesRequest servicesRequest) {
        Services services = servicesRepository.findById(id).orElseThrow();
        services.setName(servicesRequest.name());
        services.setDescription(servicesRequest.description());
        services.setPrice(servicesRequest.price());
        services.setImgUrl(servicesRequest.imgUrl());
        services.setActive(servicesRequest.active());
        services = servicesRepository.save(services);
        return servicesMapper.toResponse(services);
    }

    public void delete(Integer id) {
        servicesRepository.deleteById(id);
    }

}
