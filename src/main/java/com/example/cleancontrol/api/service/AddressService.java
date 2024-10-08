package com.example.cleancontrol.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.cleancontrol.api.dto.addressDto.AddressRequest;
import com.example.cleancontrol.api.mapper.AddressMapper;
import com.example.cleancontrol.domain.model.Address;
import com.example.cleancontrol.domain.repository.AddressRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    public List<Address> getAllAddress() {
        try {
            List<Address> address = addressRepository.findAll();

            return address;

        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar Address");
        }

    }

    public Address getAddressById(Integer id) {
        try {
            if (id == null) {
                throw new NullPointerException();
            }

            Address address = addressRepository.findById(id).orElseThrow();
            return address;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar categorias");
        }
    }

    public Address saveAddress(AddressRequest data) {
        try {

            if (data == null) {
                throw new NullPointerException();
            }

            Address address = addressMapper.toEntity(data);

            addressRepository.save(address);

            return address;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar o endereço");
        }
    }

    public Address updateAddress(Integer id, AddressRequest data) {
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

            return  newAddress;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar o endereço");
            
        }
    }

    public void deleteAddress(Integer id) {

        try {
            if (id == null) {
                throw new NullPointerException();
            }

            addressRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar o endereço");

        }
    }
}
