package com.example.cleancontrol.api.dto.transactionDto;

import java.time.LocalDateTime;

import com.example.cleancontrol.domain.model.Client;
import com.example.cleancontrol.domain.model.Enterprise;
import com.example.cleancontrol.domain.model.TransactionType;

import lombok.Builder;

@Builder
public record TransactionResponse(Integer id, Double total, String paymentMethod, TransactionType transactionType, String status, Enterprise enterprise, Client client, LocalDateTime createDate, LocalDateTime updateDate) {

}
