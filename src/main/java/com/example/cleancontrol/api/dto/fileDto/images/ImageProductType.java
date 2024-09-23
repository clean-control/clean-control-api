package com.example.cleancontrol.api.dto.fileDto.images;

import com.example.cleancontrol.domain.model.ProductType;

public record ImageProductType(Integer id, String name, String description, String fileExtension, String path,Double fileSize, ProductType productType) {

}
