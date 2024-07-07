package com.example.cleancontrol.dto.addressDto;


import lombok.Builder;

@Builder
public record AddressRequest(String street, Integer number, String complement, String neighborhood, String city,
        String state, String cep) {

}
