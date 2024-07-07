package com.example.cleancontrol.dto.employeeDto;

import java.sql.Date;
import java.time.LocalDateTime;

import com.example.cleancontrol.model.EmployeeType;
import com.example.cleancontrol.model.Enterprise;

import lombok.Builder;

@Builder
public record EmployeeResponse(Integer id, String name, String lastname, String nickname, String email, String password,
        String cpf, String phone, Date dateBirth, String imgUrl, Boolean active, EmployeeType employeeType,
        Enterprise enterprise, LocalDateTime createDate, LocalDateTime updateDate) {

}
