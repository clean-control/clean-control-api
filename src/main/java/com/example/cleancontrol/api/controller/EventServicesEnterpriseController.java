package com.example.cleancontrol.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.example.cleancontrol.api.dto.eventServicesEnterpriseDto.EventServicesEnterpriseRequest;
import com.example.cleancontrol.api.dto.eventServicesEnterpriseDto.EventServicesEnterpriseResponse;

import com.example.cleancontrol.api.service.EventServicesEnterpriseService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/event-services-enterprise")
@RequiredArgsConstructor
public class EventServicesEnterpriseController {

    private final EventServicesEnterpriseService eventServicesEnterpriseService ;

    @PostMapping
    public ResponseEntity<EventServicesEnterpriseResponse> save(@RequestBody EventServicesEnterpriseRequest eventServicesEnterpriseRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(eventServicesEnterpriseService.save(eventServicesEnterpriseRequest));
    }

    @GetMapping
    public ResponseEntity<List<EventServicesEnterpriseResponse>> findAll() {
        return ResponseEntity.ok(eventServicesEnterpriseService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventServicesEnterpriseResponse> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(eventServicesEnterpriseService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventServicesEnterpriseResponse> update(@PathVariable Integer id, @RequestBody EventServicesEnterpriseRequest eventServicesEnterpriseRequest) {
        return ResponseEntity.ok(eventServicesEnterpriseService.update(id, eventServicesEnterpriseRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        eventServicesEnterpriseService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
