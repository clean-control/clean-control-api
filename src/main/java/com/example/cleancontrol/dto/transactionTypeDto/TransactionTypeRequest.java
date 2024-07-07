package com.example.cleancontrol.dto.transactionTypeDto;

import lombok.Builder;

@Builder
public record TransactionTypeRequest(String name, String description, Boolean active) {

}
