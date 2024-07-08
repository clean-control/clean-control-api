package com.example.cleancontrol.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;


import com.example.cleancontrol.api.dto.addressDto.AddressResponse;
import com.example.cleancontrol.api.mapper.AddressMapper;
import com.example.cleancontrol.domain.model.Address;
import com.example.cleancontrol.domain.repository.AddressRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    public List<AddressResponse> getAllAddress() {
        List<Address> address = addressRepository.findAll();

        return address.stream().map(addressMapper::toResponse).collect(Collectors.toList());


    }

}
