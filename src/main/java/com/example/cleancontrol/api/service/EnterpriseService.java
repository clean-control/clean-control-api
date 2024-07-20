package com.example.cleancontrol.api.service;

import lombok.RequiredArgsConstructor;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.cleancontrol.api.dto.enterpriseDto.EnterpriseRequest;
import com.example.cleancontrol.api.dto.enterpriseDto.EnterpriseResponse;
import com.example.cleancontrol.api.mapper.EnterpriseMapper;

import com.example.cleancontrol.domain.model.Enterprise;
import com.example.cleancontrol.domain.model.Address;

import com.example.cleancontrol.domain.repository.EnterpriseRepository;
import com.example.cleancontrol.domain.repository.AddressRepository;

@Service
@RequiredArgsConstructor
public class EnterpriseService {

    private final EnterpriseRepository enterpriseRepository;
    private final AddressRepository addressRepository;
    private final EnterpriseMapper enterpriseMapper;

    public List<EnterpriseResponse> findAll() {
        try {
            return enterpriseMapper.toResponse(enterpriseRepository.findAll());
        } catch (Exception e) {
            throw new RuntimeException("Error to get enterprises");
        }
    }

    public EnterpriseResponse findById(Integer id) {
        try {
            return enterpriseMapper.toResponse(enterpriseRepository.findById(id).get());
        } catch (Exception e) {
            throw new RuntimeException("Error to get enterprise");
        }
    }

    public EnterpriseResponse save(EnterpriseRequest enterpriseRequest) {
        try {

            if (enterpriseRequest == null) {
                throw new RuntimeException("Enterprise is null");
            }

            Address address = addressRepository.findById(enterpriseRequest.addressId()).get();

            Enterprise enterprise = Enterprise.builder()
                    .name(enterpriseRequest.name())
                    .cnpj(enterpriseRequest.cnpj())
                    .phone(enterpriseRequest.phone())
                    .email(enterpriseRequest.email())
                    .password(enterpriseRequest.password())
                    .imgLogo(enterpriseRequest.imgLogo())
                    .active(enterpriseRequest.active())
                    .address(address)
                    .build();

            return enterpriseMapper.toResponse(enterpriseRepository.save(enterprise));

        } catch (Exception e) {
            throw new RuntimeException("Error to get address");
        }
    }

    public EnterpriseResponse update(Integer id, EnterpriseRequest enterpriseRequest) {
        try {
            Enterprise enterprise = enterpriseRepository.findById(id).get();

            if (enterpriseRequest == null) {
                throw new RuntimeException("Enterprise is null");
            }

            Address address = addressRepository.findById(enterpriseRequest.addressId()).get();

            enterprise.setName(enterpriseRequest.name() != null ? enterpriseRequest.name() : enterprise.getName());
            enterprise.setCnpj(enterpriseRequest.cnpj() != null ? enterpriseRequest.cnpj() : enterprise.getCnpj());
            enterprise.setPhone(enterpriseRequest.phone() != null ? enterpriseRequest.phone() : enterprise.getPhone());
            enterprise.setEmail(enterpriseRequest.email() != null ? enterpriseRequest.email() : enterprise.getEmail());
            enterprise.setPassword(enterpriseRequest.password() != null ? enterpriseRequest.password() : enterprise.getPassword());
            enterprise.setImgLogo(enterpriseRequest.imgLogo() != null ? enterpriseRequest.imgLogo() : enterprise.getImgLogo());
            enterprise.setActive(enterpriseRequest.active() != null ? enterpriseRequest.active() : enterprise.getActive());
            enterprise.setAddress(address);

            return enterpriseMapper.toResponse(enterpriseRepository.save(enterprise));
        } catch (Exception e) {
            throw new RuntimeException("Error to update enterprise");
        }
    }
}
