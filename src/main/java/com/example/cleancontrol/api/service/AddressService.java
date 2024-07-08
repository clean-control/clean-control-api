package com.example.cleancontrol.api.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.cleancontrol.api.dto.addressDto.AddressRequest;
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
        try {
            List<Address> address = addressRepository.findAll();

            return address.stream().map(addressMapper::toResponse).collect(Collectors.toList());

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    public AddressResponse getAddressById(Integer id) {
        try {
            if (id == null) {
                throw new NullPointerException();
            }

            Address address = addressRepository.findById(id).orElseThrow();
            return addressMapper.toResponse(address);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public AddressResponse saveAddress(AddressRequest data) {
        try {

            if (data == null) {
                throw new NullPointerException();
            }

            Address address = addressMapper.toEntity(data);

            addressRepository.save(address);

            return addressMapper.toResponse(address);
        } catch (Exception e) {
            System.out.println(e.getMessage());

            return null;
        }
    }

    public AddressResponse updateAddress(Integer id, AddressRequest data) {
        try {

            if (id == null || data == null) {
                throw new NullPointerException();
            }

            Address address = addressRepository.findById(id).orElseThrow();

            if (address == null) {
                throw new NullPointerException();
            }

            Address newAddress = Address.builder()
                    .id(id)
                    .street(data.street() != null ? data.street() : address.getStreet())
                    .number(data.number() != null ? data.number() : address.getNumber())
                    .complement(data.complement() != null ? data.complement() : address.getComplement())
                    .neighborhood(data.neighborhood() != null ? data.neighborhood() : address.getNeighborhood())
                    .city(data.city() != null ? data.city() : address.getCity())
                    .state(data.state() != null ? data.state() : address.getState())
                    .cep(data.cep() != null ? data.cep() : address.getCep())
                    .createDate(address.getCreateDate())
                    .build();

            return addressMapper.toResponse(addressRepository.save(newAddress));
        } catch (Exception e) {
            return null;
        }
    }

    public void deleteAddress(Integer id) {

        try {
            if (id == null) {
                throw new NullPointerException();
            }

            addressRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
