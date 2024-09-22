package com.example.cleancontrol.api.service;
import lombok.RequiredArgsConstructor;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.cleancontrol.api.dto.employeeTypeDto.EmployeeTypeRequest;
import com.example.cleancontrol.api.mapper.EmployeeTypeMapper;

import com.example.cleancontrol.domain.model.EmployeeType;
import com.example.cleancontrol.domain.repository.EmployeeTypeRepository;

@Service
@RequiredArgsConstructor
public class EmployeeTypeService {

    private final EmployeeTypeRepository employeeTypeRepository;
    private final EmployeeTypeMapper employeeTypeMapper;

    public List<EmployeeType> findAll() {
        try {
            return employeeTypeRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error to get employee types");
        }
    }

    public EmployeeType findById(Integer id) {
        try {
            return employeeTypeRepository.findById(id).get();
        } catch (Exception e) {
            throw new RuntimeException("Error to get employee type");
        }
    }

    public EmployeeType save(EmployeeTypeRequest employeeTypeRequest) {
        try {
            EmployeeType employeeType = employeeTypeMapper.toEntity(employeeTypeRequest);
            return employeeTypeRepository.save(employeeType);
        } catch (Exception e) {
            throw new RuntimeException("Error to save employee type");
        }
    }

    public EmployeeType update(Integer id, EmployeeTypeRequest employeeTypeRequest) {
        try {
            EmployeeType employeeType = employeeTypeRepository.findById(id).orElseThrow();

            employeeType.setActive(employeeTypeRequest.active()!=null?employeeTypeRequest.active():employeeType.getActive());
            employeeType.setDescription(employeeTypeRequest.description()!=null?employeeTypeRequest.description():employeeType.getDescription());
            employeeType.setName(employeeTypeRequest.name()!=null?employeeTypeRequest.name():employeeType.getName());

            return employeeTypeRepository.save(employeeType);
        } catch (Exception e) {
            throw new RuntimeException("Error to update employee type");
        }
    }

    public void delete(Integer id) {
        try {
            EmployeeType employeeType = employeeTypeRepository.findById(id).orElseThrow();

            if (employeeType.getActive()) {
                
                employeeType.setActive(false);
                employeeTypeRepository.save(employeeType);
            } else {
                employeeTypeRepository.delete(employeeType);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error to delete employee type");
        }
    }


    public void active(Integer id) {
        try {
            EmployeeType employeeType = employeeTypeRepository.findById(id).orElseThrow();

            employeeType.setActive(true);
            employeeTypeRepository.save(employeeType);
        } catch (Exception e) {
            throw new RuntimeException("Error to active employee type");
        }
    }


}
