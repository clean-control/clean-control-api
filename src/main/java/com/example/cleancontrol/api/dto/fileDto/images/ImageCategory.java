package com.example.cleancontrol.api.dto.fileDto.images;

import com.example.cleancontrol.domain.model.Category;
import lombok.Builder;

@Builder
public record ImageCategory(Integer id, String name, String description, String fileExtension, String path,Double fileSize, Category category) {

}
