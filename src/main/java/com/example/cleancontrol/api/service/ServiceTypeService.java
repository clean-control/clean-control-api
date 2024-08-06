package com.example.cleancontrol.api.service;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import com.example.cleancontrol.domain.repository.CategoryRepository;
import com.example.cleancontrol.domain.repository.ServiceTypeRepository;
import com.example.cleancontrol.domain.model.ServiceType;
import com.example.cleancontrol.api.mapper.ServiceTypeMapper;
import com.example.cleancontrol.api.dto.serviceTypeDto.ServiceTypeRequest;
import com.example.cleancontrol.api.dto.serviceTypeDto.ServiceTypeResponse;
import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class ServiceTypeService {

    private final ServiceTypeRepository serviceTypeRepository;
    private final ServiceTypeMapper serviceTypeMapper;
    private final CategoryRepository categoryRepository;

    public List<ServiceTypeResponse> findAll() {
        List<ServiceType> serviceTypes = serviceTypeRepository.findAll();
        return serviceTypes.stream().map(serviceTypeMapper::toResponse).collect(Collectors.toList());
    }

    public ServiceTypeResponse findById(Integer id) {
        ServiceType serviceType = serviceTypeRepository.findById(id).orElseThrow();
        return serviceTypeMapper.toResponse(serviceType);
    }

    public ServiceTypeResponse save(ServiceTypeRequest serviceTypeRequest) {
        ServiceType serviceType = new ServiceType();
        serviceType.setName(serviceTypeRequest.name());
        serviceType.setDescription(serviceTypeRequest.description());
        serviceType.setCategory(categoryRepository.findById(serviceTypeRequest.categoryId()).orElse(null));
        serviceType.setImgUrl(serviceTypeRequest.imgUrl());
        serviceType.setActive(serviceTypeRequest.active());
        serviceType = serviceTypeRepository.save(serviceType);
        return serviceTypeMapper.toResponse(serviceType);
    }

    public ServiceTypeResponse update(Integer id, ServiceTypeRequest serviceTypeRequest) {
        ServiceType serviceType = serviceTypeRepository.findById(id).orElseThrow();
        serviceType.setName(serviceTypeRequest.name());
        serviceType.setDescription(serviceTypeRequest.description());
        serviceType.setCategory(categoryRepository.findById(serviceTypeRequest.categoryId()).orElse(null));
        serviceType.setImgUrl(serviceTypeRequest.imgUrl());
        serviceType.setActive(serviceTypeRequest.active());
        serviceType = serviceTypeRepository.save(serviceType);
        return serviceTypeMapper.toResponse(serviceType);
    }

    public void delete(Integer id) {
        serviceTypeRepository.deleteById(id);
    }
}
