package com.example.cleancontrol.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cleancontrol.api.dto.addressDto.AddressRequest;
import com.example.cleancontrol.api.dto.addressDto.AddressResponse;
import com.example.cleancontrol.api.mapper.AddressMapper;
import com.example.cleancontrol.api.service.AddressService;
import com.example.cleancontrol.domain.model.UserAddress;
import com.example.cleancontrol.domain.repository.UserAddressRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;
    private final AddressMapper addressMapper;

    private final UserAddressRepository userAddressRepository;

    @GetMapping("/user")
    public ResponseEntity<List<UserAddress>> getAllUser() {

        try {
            List<UserAddress> user = userAddressRepository.findAll();
            return ResponseEntity.ok(user);
        } catch (Exception e) {
             
            return ResponseEntity.badRequest().build();
        }

    }

    @GetMapping
    public ResponseEntity<List<AddressResponse>> getAllAddress() {

        try {
            List<AddressResponse> address =  addressService.getAllAddress().stream().map(addressMapper::toResponse).collect(Collectors.toList());
            return ResponseEntity.ok(address);
        } catch (Exception e) {
             
            return ResponseEntity.badRequest().build();
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressResponse> getAddressById(@PathVariable Integer id) {

        try {
            AddressResponse address =addressMapper.toResponse( addressService.getAddressById(id));
            return ResponseEntity.ok(address);
        } catch (Exception e) {
             
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<AddressResponse> createAddress(@RequestBody AddressRequest data) {

        try {
            AddressResponse address = addressMapper.toResponse( addressService.saveAddress(data));
            return ResponseEntity.ok(address);
        } catch (Exception e) {
             
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressResponse> updateAddress(@PathVariable Integer id, @RequestBody AddressRequest data) {

        try {
            AddressResponse address =addressMapper.toResponse( addressService.updateAddress(id, data));
            return ResponseEntity.ok(address);
        } catch (Exception e) {
             
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Integer id) {

        try {
            addressService.deleteAddress(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
             
            return ResponseEntity.badRequest().build();
        }
    }
}
