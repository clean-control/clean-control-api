package com.example.cleancontrol.api.mapper;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.cleancontrol.api.dto.employeeTypeDto.*;

import com.example.cleancontrol.domain.model.EmployeeType;


@Component
public class EmployeeTypeMapper {

    public List<EmployeeTypeResponse> toResponse(List<EmployeeType> employeeType) {
        return employeeType.stream().map(this::toResponse).collect(Collectors.toList());
    }

    public EmployeeTypeResponse toResponse(EmployeeType employeeType) {
        return EmployeeTypeResponse.builder()
                .id(employeeType.getId())
                .name(employeeType.getName())
                .description(employeeType.getDescription())
                .active(employeeType.getActive())
                .createDate(employeeType.getCreateDate())
                .updateDate(employeeType.getUpdateDate())
                .build();
    }

    public EmployeeType toEntity(EmployeeTypeRequest employeeTypeRequest) {
        return EmployeeType.builder()
                .name(employeeTypeRequest.name())
                .description(employeeTypeRequest.description())
                .active(employeeTypeRequest.active())
                .build();
    }

   
    

}
