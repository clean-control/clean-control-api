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

import com.example.cleancontrol.api.dto.enterpriseDto.EnterpriseRequest;
import com.example.cleancontrol.api.dto.enterpriseDto.EnterpriseResponse;
import com.example.cleancontrol.api.mapper.EnterpriseMapper;
import com.example.cleancontrol.api.service.EnterpriseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/enterprises")
@RequiredArgsConstructor
public class EnterpriseController {

    private final EnterpriseService enterpriseService;
    private final EnterpriseMapper enterpriseMapper;

    @GetMapping
    public ResponseEntity<List<EnterpriseResponse>> findAll() {
        return ResponseEntity.ok(enterpriseService.findAll().stream().map(enterpriseMapper::toResponse).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnterpriseResponse> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(enterpriseMapper.toResponse(enterpriseService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<EnterpriseResponse> save(@RequestBody EnterpriseRequest enterpriseRequest) {
        return ResponseEntity.ok(enterpriseMapper.toResponse(enterpriseService.save(enterpriseRequest)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnterpriseResponse> update(@PathVariable Integer id, @RequestBody EnterpriseRequest enterpriseRequest) {
        return ResponseEntity.ok(enterpriseMapper.toResponse(enterpriseService.update(id, enterpriseRequest)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        enterpriseService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
