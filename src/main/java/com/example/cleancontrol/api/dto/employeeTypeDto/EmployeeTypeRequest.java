package com.example.cleancontrol.api.dto.employeeTypeDto;

import lombok.Builder;

@Builder
public record EmployeeTypeRequest(String name, String description, Boolean active) {

}
