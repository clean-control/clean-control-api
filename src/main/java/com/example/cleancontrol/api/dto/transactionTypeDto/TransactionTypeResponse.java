package com.example.cleancontrol.api.dto.transactionTypeDto;

import java.time.LocalDateTime;

import lombok.Builder;

@Builder
public record TransactionTypeResponse(Integer id, String name, String description, Boolean active,
        LocalDateTime createDate, LocalDateTime updateDate) {

}