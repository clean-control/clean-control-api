package com.example.cleancontrol.api.dto.transactionTypeDto;

import lombok.Builder;

@Builder
public record TransactionTypeRequest(String name, String description, Boolean active) {

}
