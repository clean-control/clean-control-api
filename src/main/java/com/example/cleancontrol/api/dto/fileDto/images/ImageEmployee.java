package com.example.cleancontrol.api.dto.fileDto.images;

import com.example.cleancontrol.domain.model.Employee;

public record ImageEmployee(Integer id, String name, String description, String fileExtension, String path,Double fileSize, Employee employee) {

}
