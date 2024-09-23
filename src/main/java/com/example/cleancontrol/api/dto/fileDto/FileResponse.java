package com.example.cleancontrol.api.dto.fileDto;

import java.time.LocalDateTime;

import com.example.cleancontrol.domain.model.Category;
import com.example.cleancontrol.domain.model.Client;
import com.example.cleancontrol.domain.model.Employee;
import com.example.cleancontrol.domain.model.Enterprise;
import com.example.cleancontrol.domain.model.Product;
import com.example.cleancontrol.domain.model.ProductType;
import com.example.cleancontrol.domain.model.ServiceType;
import com.example.cleancontrol.domain.model.Services;

public record FileResponse(Integer id, String name, String description, String fileExtension, String path,Double fileSize, Client client, Employee employee, Enterprise enterprise , Category category,Product product,Services service,ProductType productType,ServiceType serviceType, LocalDateTime createDate, LocalDateTime updateDate) {


}
