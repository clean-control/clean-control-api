package com.example.cleancontrol.api.controller;


import java.util.List;

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
import com.example.cleancontrol.api.service.AddressService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/address")
@RequiredArgsConstructor
public class AddressController {


    private final AddressService addressService;

    @GetMapping
    public ResponseEntity<List<AddressResponse>> getAllAddress() {
        // return addressService.getAllAddress();
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressResponse> getAddressById(@PathVariable Integer id) {
        // return addressService.getAddressById(id);
        return null;

    }


    @PostMapping
    public  ResponseEntity<AddressResponse> createAddress(@RequestBody AddressRequest data){
        // return addressService.createAddress(data);
        return null;

    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressResponse> updateAddress(@PathVariable Integer id, @RequestBody AddressRequest data){
        // return addressService.updateAddress(id, data);
        return null;

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Integer id){
        // return addressService.deleteAddress(id);
        return null;

    }
}
