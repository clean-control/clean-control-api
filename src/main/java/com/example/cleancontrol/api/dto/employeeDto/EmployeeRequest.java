package com.example.cleancontrol.api.dto.employeeDto;

import java.sql.Date;

import lombok.Builder;

@Builder
public record EmployeeRequest(String name, String lastname, String nickname, String email, String password,
        String cpf, String phone, Date dateBirth, String imgUrl, Boolean active, Integer employeeTypeId, Integer userTypeId,
        Integer enterpriseId) {

}
