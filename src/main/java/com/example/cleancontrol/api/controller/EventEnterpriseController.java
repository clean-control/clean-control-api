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

import com.example.cleancontrol.api.dto.eventEnterpriseDto.EventEnterpriseRequest;
import com.example.cleancontrol.api.dto.eventEnterpriseDto.EventEnterpriseResponse;

import com.example.cleancontrol.api.service.EventEnterpriseService;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/event-enterprise")
@RequiredArgsConstructor
public class EventEnterpriseController {

    private final EventEnterpriseService eventEnterpriseService ;

    @PostMapping
    public ResponseEntity<EventEnterpriseResponse> save(@RequestBody EventEnterpriseRequest eventEnterpriseRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(eventEnterpriseService.save(eventEnterpriseRequest));
    }

    @GetMapping
    public ResponseEntity<List<EventEnterpriseResponse>> findAll() {
        return ResponseEntity.ok(eventEnterpriseService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventEnterpriseResponse> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(eventEnterpriseService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventEnterpriseResponse> update(@PathVariable Integer id, @RequestBody EventEnterpriseRequest eventEnterpriseRequest) {
        return ResponseEntity.ok(eventEnterpriseService.update(id, eventEnterpriseRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        eventEnterpriseService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
