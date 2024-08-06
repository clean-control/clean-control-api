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

import com.example.cleancontrol.api.service.EmployeeTypeService;

import com.example.cleancontrol.api.dto.employeeTypeDto.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/employeeType")
@RequiredArgsConstructor
public class EmployeeTypeController {

    private final EmployeeTypeService employeeTypeService;

    @GetMapping
    public ResponseEntity<List<EmployeeTypeResponse>> getAllEmployeeType(){

          try {
            List<EmployeeTypeResponse> employeeType = employeeTypeService.findAll();
            return ResponseEntity.ok(employeeType);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeTypeResponse> getEmployeeType(@PathVariable Integer id){
        try {
            EmployeeTypeResponse employeeType = employeeTypeService.findById(id);
            return ResponseEntity.ok(employeeType);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<EmployeeTypeResponse> saveEmployeeType(@RequestBody EmployeeTypeRequest data){
        try {
            EmployeeTypeResponse employeeType = employeeTypeService.save(data);
            return ResponseEntity.ok(employeeType);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeTypeResponse> updateEmployeeType(@PathVariable Integer id, @RequestBody EmployeeTypeRequest data){
        try {
            EmployeeTypeResponse employeeType = employeeTypeService.update(id, data);
            return ResponseEntity.ok(employeeType);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EmployeeTypeResponse> deleteEmployeeType(@PathVariable Integer id){
        try {
            employeeTypeService.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/active/{id}")
    public ResponseEntity<Void> getActiveEmployeeType(@PathVariable Integer id){
        try {
            employeeTypeService.active(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
      
    }



}
