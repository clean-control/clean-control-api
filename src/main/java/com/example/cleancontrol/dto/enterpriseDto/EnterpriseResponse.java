package com.example.cleancontrol.dto.enterpriseDto;

import java.time.LocalDateTime;

import com.example.cleancontrol.model.Address;

import lombok.Builder;

@Builder
public record EnterpriseResponse(Integer id, String name, String cnpj, String phone, String email, String password,
        String imgLogo, Boolean active, Address address, LocalDateTime createDate, LocalDateTime updateDate) {

}