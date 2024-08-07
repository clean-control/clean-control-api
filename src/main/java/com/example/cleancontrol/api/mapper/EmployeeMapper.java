package com.example.cleancontrol.api.mapper;

import org.springframework.stereotype.Component;

import com.example.cleancontrol.api.dto.employeeDto.EmployeeResponse;
import com.example.cleancontrol.domain.model.EmployeeType;
import com.example.cleancontrol.domain.model.Enterprise;
import com.example.cleancontrol.domain.model.User;

@Component
public class EmployeeMapper {

    public EmployeeResponse toResponse(User employee, EmployeeType employeeType, Enterprise enterprise) {
        return EmployeeResponse.builder()
                .id(employee.getId())
                .name(employee.getName())
                .lastname(employee.getLastname())
                .cpf(employee.getCpf())
                .email(employee.getEmail())
                .phone(employee.getPhone())
                .dateBirth(employee.getDateBirth())
                .imgUrl(employee.getImgUrl())
                .password(employee.getPassword())
                .nickname(employee.getNickname())
                .employeeType(employeeType)
                .enterprise(enterprise)
                .active(employee.getActive())
                .createDate(employee.getCreateDate())
                .updateDate(employee.getUpdateDate())
                .build();
    }

  
   

}
