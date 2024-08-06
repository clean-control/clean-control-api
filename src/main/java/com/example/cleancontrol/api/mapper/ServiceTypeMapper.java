package com.example.cleancontrol.api.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.cleancontrol.domain.model.ServiceType;
import com.example.cleancontrol.api.dto.serviceTypeDto.ServiceTypeResponse;

@Component
public class ServiceTypeMapper {

    public ServiceTypeResponse toResponse(ServiceType serviceType) {
        return ServiceTypeResponse.builder()
                .id(serviceType.getId())
                .name(serviceType.getName())
                .description(serviceType.getDescription())
                .category(serviceType.getCategory())
                .imgUrl(serviceType.getImgUrl())
                .active(serviceType.getActive())
                .createDate(serviceType.getCreateDate())
                .updateDate(serviceType.getUpdateDate())
                .build();
    }

    public ServiceType toEntity(ServiceTypeResponse serviceTypeResponse) {
        return ServiceType.builder()
                .id(serviceTypeResponse.id())
                .name(serviceTypeResponse.name())
                .description(serviceTypeResponse.description())
                .category(serviceTypeResponse.category())
                .imgUrl(serviceTypeResponse.imgUrl())
                .active(serviceTypeResponse.active())
                .createDate(serviceTypeResponse.createDate())
                .updateDate(serviceTypeResponse.updateDate())
                .build();
    }

    public List<ServiceTypeResponse> toResponse(List<ServiceType> serviceTypes) {
        return serviceTypes.stream().map(this::toResponse).toList();
    }
}
