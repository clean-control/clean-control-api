package com.example.cleancontrol.api.dto.fileDto.images;

import com.example.cleancontrol.domain.model.Enterprise;
import lombok.Builder;

@Builder
public record ImageEnterprise(Integer id, String name, String description, String fileExtension, String path,Double fileSize, Enterprise enterprise) {

}
