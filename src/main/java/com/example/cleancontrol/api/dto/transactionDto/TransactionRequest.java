package com.example.cleancontrol.api.dto.transactionDto;

import lombok.Builder;

@Builder
public record TransactionRequest(Double total, String paymentMethod, Integer transactionTypeId, String status, Integer enterpriseId, Integer clientId) {

}
