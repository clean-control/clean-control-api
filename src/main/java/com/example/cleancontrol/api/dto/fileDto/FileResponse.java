package com.example.cleancontrol.api.dto.fileDto;

import java.time.LocalDateTime;

import com.example.cleancontrol.domain.model.Client;
import com.example.cleancontrol.domain.model.Employee;

public record FileResponse(Integer id, String name, String description, String fileExtension, String path,Double fileSize, Client client, Employee employee, LocalDateTime createDate, LocalDateTime updateDate) {

}
