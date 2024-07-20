package com.example.cleancontrol.api.mapper;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.cleancontrol.api.dto.enterpriseDto.EnterpriseResponse;
import com.example.cleancontrol.domain.model.Enterprise;

@Component
public class EnterpriseMapper {

    public List<EnterpriseResponse> toResponse(List<Enterprise> enterprise) {
        return enterprise.stream().map(this::toResponse).collect(Collectors.toList());
    }

    public EnterpriseResponse toResponse(Enterprise enterprise) {
        return EnterpriseResponse.builder()
                .id(enterprise.getId())
                .name(enterprise.getName())
                .cnpj(enterprise.getCnpj())
                .phone(enterprise.getPhone())
                .email(enterprise.getEmail())
                .password(enterprise.getPassword())
                .imgLogo(enterprise.getImgLogo())
                .active(enterprise.getActive())
                .address(enterprise.getAddress())
                .createDate(enterprise.getCreateDate())
                .updateDate(enterprise.getUpdateDate())
                .build();
    }

    
}
