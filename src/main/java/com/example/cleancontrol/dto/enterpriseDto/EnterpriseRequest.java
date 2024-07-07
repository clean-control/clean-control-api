package com.example.cleancontrol.dto.enterpriseDto;

import lombok.Builder;

@Builder
public record EnterpriseRequest(String name, String cnpj, String phone, String email, String password,
        String imgLogo, Boolean active, Integer addressId) {

}
