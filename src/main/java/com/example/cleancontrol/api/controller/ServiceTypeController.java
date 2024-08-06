package com.example.cleancontrol.api.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.example.cleancontrol.api.dto.serviceTypeDto.ServiceTypeRequest;
import com.example.cleancontrol.api.dto.serviceTypeDto.ServiceTypeResponse;

import com.example.cleancontrol.api.service.ServiceTypeService;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/service-type")
@RequiredArgsConstructor
public class ServiceTypeController {

    private final ServiceTypeService serviceTypeService ;

    @PostMapping
    public ResponseEntity<ServiceTypeResponse> save(@RequestBody ServiceTypeRequest serviceTypeRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceTypeService.save(serviceTypeRequest));
    }

    @GetMapping
    public ResponseEntity<List<ServiceTypeResponse>> findAll() {
        return ResponseEntity.ok(serviceTypeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceTypeResponse> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(serviceTypeService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceTypeResponse> update(@PathVariable Integer id, @RequestBody ServiceTypeRequest serviceTypeRequest) {
        return ResponseEntity.ok(serviceTypeService.update(id, serviceTypeRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        serviceTypeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
