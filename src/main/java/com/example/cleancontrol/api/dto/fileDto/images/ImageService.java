package com.example.cleancontrol.api.dto.fileDto.images;

import com.example.cleancontrol.domain.model.Services;

public record ImageService(Integer id, String name, String description, String fileExtension, String path,Double fileSize, Services services) {

}
