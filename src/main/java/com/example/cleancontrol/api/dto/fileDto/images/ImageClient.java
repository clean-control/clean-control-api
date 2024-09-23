package com.example.cleancontrol.api.dto.fileDto.images;

import com.example.cleancontrol.domain.model.Client;

public record ImageClient(Integer id, String name, String description, String fileExtension, String path,Double fileSize, Client client) {

}