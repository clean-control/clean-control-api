package com.example.cleancontrol.api.dto.addressDto;

import java.time.LocalDateTime;

import lombok.Builder;

@Builder
public record AddressResponse(Integer id, String street, Integer number, String complement, String neighborhood,
        String city, String state, String cep, LocalDateTime createDate, LocalDateTime updateDate) {

}
