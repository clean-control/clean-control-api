package com.example.cleancontrol.api.mapper;

import org.springframework.stereotype.Component;

import com.example.cleancontrol.api.dto.employeeDto.EmployeeResponse;
import com.example.cleancontrol.domain.model.Employee;
import com.example.cleancontrol.domain.model.EmployeeType;
import com.example.cleancontrol.domain.model.Enterprise;
import com.example.cleancontrol.domain.model.Users;

@Component
public class EmployeeMapper {

    public EmployeeResponse toResponse(Users employee, EmployeeType employeeType, Enterprise enterprise) {
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
                .userType(employee.getUserType())
                .build();
    }

    public EmployeeResponse toResponse(Employee employee){
        return EmployeeResponse.builder()
                .id(employee.getUser().getId())
                .name(employee.getUser().getName())
                .lastname(employee.getUser().getLastname())
                .cpf(employee.getUser().getCpf())
                .email(employee.getUser().getEmail())
                .phone(employee.getUser().getPhone())
                .dateBirth(employee.getUser().getDateBirth())
                .imgUrl(employee.getUser().getImgUrl())
                .password(employee.getUser().getPassword())
                .nickname(employee.getUser().getNickname())
                .employeeType(employee.getEmployeeType())
                .enterprise(employee.getEnterprise())
                .active(employee.getUser().getActive())
                .createDate(employee.getUser().getCreateDate())
                .updateDate(employee.getUser().getUpdateDate())
                .userType(employee.getUser().getUserType())
                .build();
    }

  
   

}
