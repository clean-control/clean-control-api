package com.example.cleancontrol.api.mapper;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.cleancontrol.api.dto.employeeDto.EmployeeResponse;
import com.example.cleancontrol.domain.model.Employee;

@Component
public class EmployeeMapper {

    public EmployeeResponse toResponse(Employee employee) {
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
                .employeeType(employee.getEmployeeType())
                .enterprise(employee.getEnterprise())
                .active(employee.getActive())
                .createDate(employee.getCreateDate())
                .updateDate(employee.getUpdateDate())
                .build();
    }

    public List<EmployeeResponse> toResponse(List<Employee> employee) {
        return employee.stream().map(this::toResponse).collect(Collectors.toList());
    }

}
