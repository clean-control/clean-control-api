package com.example.cleancontrol.api.dto.employeeDto;

import java.sql.Date;
import java.time.LocalDateTime;

import com.example.cleancontrol.domain.model.EmployeeType;
import com.example.cleancontrol.domain.model.Enterprise;
import com.example.cleancontrol.domain.model.UserType;

import lombok.Builder;

@Builder
public record EmployeeResponse(Integer id, String name, String lastname, String nickname, String email, String password,
        String cpf, String phone, Date dateBirth, String imgUrl, Boolean active, EmployeeType employeeType,UserType userType,
        Enterprise enterprise, LocalDateTime createDate, LocalDateTime updateDate) {

}
