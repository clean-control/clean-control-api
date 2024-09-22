package com.example.cleancontrol.api.controller;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cleancontrol.api.service.EmployeeService;

import com.example.cleancontrol.api.dto.employeeDto.*;
import com.example.cleancontrol.api.mapper.EmployeeMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> getAllEmployee(){

          try {
            List<EmployeeResponse> employee = employeeService.findAll().stream().map(employeeMapper::toResponse).collect(Collectors.toList());
            return ResponseEntity.ok(employee);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> getEmployee(@PathVariable Integer id){
        try {
            EmployeeResponse employee = employeeMapper.toResponse(employeeService.findById(id));
            return ResponseEntity.ok(employee);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<EmployeeResponse> saveEmployee(@RequestBody EmployeeRequest data){
        try {
            EmployeeResponse employee = employeeMapper.toResponse(employeeService.save(data));
            return ResponseEntity.ok(employee);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponse> updateEmployee(@PathVariable Integer id, @RequestBody EmployeeRequest data){
        try {
            EmployeeResponse employee = employeeMapper.toResponse(employeeService.update(id, data));
            return ResponseEntity.ok(employee);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/active/{id}")
    public ResponseEntity<Void> getActiveEmployee(@PathVariable Integer id){
        try {
            employeeService.active(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
      
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Integer id){
        try {
            employeeService.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

}
