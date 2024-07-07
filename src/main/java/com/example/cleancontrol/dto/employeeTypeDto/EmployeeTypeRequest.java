package com.example.cleancontrol.dto.employeeTypeDto;

import lombok.Builder;

@Builder
public record EmployeeTypeRequest(String name, String description, Boolean active) {

}
