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

import com.example.cleancontrol.api.dto.servicesDto.ServicesRequest;
import com.example.cleancontrol.api.dto.servicesDto.ServicesResponse;
import com.example.cleancontrol.api.mapper.ServicesMapper;
import com.example.cleancontrol.api.service.ServicesService;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/services")
@RequiredArgsConstructor
public class ServicesController {

    private final ServicesService servicesService ;
    private final ServicesMapper servicesMapper;

    @PostMapping
    public ResponseEntity<ServicesResponse> save(@RequestBody ServicesRequest servicesRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(servicesMapper.toResponse(servicesService.save(servicesRequest)));
    }

    @GetMapping
    public ResponseEntity<List<ServicesResponse>> findAll() {
        return ResponseEntity.ok(servicesService.findAll().stream().map(servicesMapper::toResponse).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicesResponse> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(servicesMapper.toResponse(servicesService.findById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServicesResponse> update(@PathVariable Integer id, @RequestBody ServicesRequest servicesRequest) {
        return ResponseEntity.ok(servicesMapper.toResponse(servicesService.update(id, servicesRequest)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        servicesService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
