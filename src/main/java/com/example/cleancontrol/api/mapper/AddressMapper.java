package com.example.cleancontrol.api.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.cleancontrol.api.dto.addressDto.AddressResponse;
import com.example.cleancontrol.api.dto.addressDto.AddressRequest;
import com.example.cleancontrol.domain.model.Address;


@Component
public class AddressMapper {

    public AddressResponse toResponse(Address address) {
        return new AddressResponse(address.getId(), address.getStreet(), address.getNumber(), address.getComplement(), address.getNeighborhood(), address.getCity(), address.getState(), address.getCep(), address.getCreateDate(), address.getUpdateDate());
    }

    public List<AddressResponse> toResponse(List<Address> address) {
        return address.stream().map(this::toResponse).collect(Collectors.toList());
    }

    public Address toEntity(AddressRequest addressRequest) {
        return new Address(null, addressRequest.street(), addressRequest.number(), addressRequest.complement(), addressRequest.neighborhood(), addressRequest.city(), addressRequest.state(), addressRequest.cep(), null, null);
    }

    public Address toEntity(AddressRequest addressRequest, Integer id) {
        return new Address(id, addressRequest.street(), addressRequest.number(), addressRequest.complement(), addressRequest.neighborhood(), addressRequest.city(), addressRequest.state(), addressRequest.cep(), null, null);
    }

}
