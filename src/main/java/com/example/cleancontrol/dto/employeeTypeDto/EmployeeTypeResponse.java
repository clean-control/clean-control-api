package com.example.cleancontrol.dto.employeeTypeDto;
import java.time.LocalDateTime;

import lombok.Builder;

@Builder
public record EmployeeTypeResponse(Integer id, String name, String description, Boolean active, LocalDateTime createDate,
LocalDateTime updateDate) {

}
