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

import com.example.cleancontrol.api.dto.eventTypeDto.EventTypeRequest;
import com.example.cleancontrol.api.dto.eventTypeDto.EventTypeResponse;

import com.example.cleancontrol.api.service.EventTypeService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/event-type")
@RequiredArgsConstructor
public class EventTypeServiceController {

    private final EventTypeService eventTypeService ;

    @PostMapping
    public ResponseEntity<EventTypeResponse> save(@RequestBody EventTypeRequest eventTypeRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(eventTypeService.save(eventTypeRequest));
    }

    @GetMapping
    public ResponseEntity<List<EventTypeResponse>> findAll() {
        return ResponseEntity.ok(eventTypeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventTypeResponse> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(eventTypeService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventTypeResponse> update(@PathVariable Integer id, @RequestBody EventTypeRequest eventTypeRequest) {
        return ResponseEntity.ok(eventTypeService.update(id, eventTypeRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        eventTypeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
