package com.example.cleancontrol.api.dto.fileDto.images;

import com.example.cleancontrol.domain.model.ServiceType;
import lombok.Builder;

@Builder
public record ImageServiceType(Integer id, String name, String description, String fileExtension, String path,Double fileSize, ServiceType serviceType) {

}
