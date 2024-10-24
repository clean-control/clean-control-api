package com.example.cleancontrol.api.dto.exceptionsDto;

import lombok.Builder;

@Builder
public record ErrorResponseDTO(int status, String message, String timestamp, String path) {

}
