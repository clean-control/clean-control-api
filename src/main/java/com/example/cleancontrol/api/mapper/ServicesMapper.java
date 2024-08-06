package com.example.cleancontrol.api.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.cleancontrol.domain.model.Services;
import com.example.cleancontrol.api.dto.servicesDto.ServicesResponse;

@Component
public class ServicesMapper {

    public ServicesResponse toResponse(Services services) {
        return ServicesResponse.builder()
                .id(services.getId())
                .name(services.getName())
                .description(services.getDescription())
                .price(services.getPrice())
                .imgUrl(services.getImgUrl())
                .active(services.getActive())
                .createDate(services.getCreateDate())
                .updateDate(services.getUpdateDate())
                .build();
    }

    public Services toEntity(ServicesResponse servicesResponse) {
        return Services.builder()
                .id(servicesResponse.id())
                .name(servicesResponse.name())
                .description(servicesResponse.description())
                .price(servicesResponse.price())
                .imgUrl(servicesResponse.imgUrl())
                .active(servicesResponse.active())
                .createDate(servicesResponse.createDate())
                .updateDate(servicesResponse.updateDate())
                .build();
    }

    public List<ServicesResponse> toResponse(List<Services> servicess) {
        return servicess.stream().map(this::toResponse).toList();
    }
}
