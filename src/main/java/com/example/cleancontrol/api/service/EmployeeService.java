package com.example.cleancontrol.api.service;

import lombok.RequiredArgsConstructor;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.cleancontrol.api.dto.employeeDto.EmployeeRequest;
import com.example.cleancontrol.api.dto.employeeDto.EmployeeResponse;
import com.example.cleancontrol.api.dto.employeeTypeDto.EmployeeTypeRequest;
import com.example.cleancontrol.api.mapper.EmployeeMapper;
import com.example.cleancontrol.domain.model.Employee;
import com.example.cleancontrol.domain.model.EmployeeType;
import com.example.cleancontrol.domain.model.Enterprise;
import com.example.cleancontrol.domain.repository.EmployeeRepository;
import com.example.cleancontrol.domain.repository.EmployeeTypeRepository;
import com.example.cleancontrol.domain.repository.EnterpriseRepository;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final EmployeeMapper employeeMapper;

    private final EmployeeTypeRepository employeeTypeRepository;

    private final EnterpriseRepository enterpriseRepository;

    public List<EmployeeResponse> findAll() {
        try {
            return employeeMapper.toResponse(employeeRepository.findAll());
        } catch (Exception e) {
            throw new RuntimeException("Error to get employees");
        }
    }

    public EmployeeResponse findById(Integer id) {
        try {
            return employeeMapper.toResponse(employeeRepository.findById(id).get());
        } catch (Exception e) {
            throw new RuntimeException("Error to get employee");
        }
    }

    public EmployeeResponse save(EmployeeRequest employeeRequest) {
        try {
            Employee employee = Employee.builder()
                    .name(employeeRequest.name())
                    .email(employeeRequest.email())
                    .password(employeeRequest.password())
                    .cpf(employeeRequest.cpf())
                    .phone(employeeRequest.phone())
                    .dateBirth(employeeRequest.dateBirth())
                    .imgUrl(employeeRequest.imgUrl())
                    .nickname(employeeRequest.nickname())
                    .lastname(employeeRequest.lastname())

                    .active(employeeRequest.active())
                    .enterprise(enterpriseRepository.findById(employeeRequest.enterpriseId()).get())
                    .employeeType(employeeTypeRepository.findById(employeeRequest.employeeTypeId()).get())
                    .build();
            return employeeMapper.toResponse(employeeRepository.save(employee));
        } catch (Exception e) {
            throw new RuntimeException("Error to save employee");
        }
    }

    public EmployeeResponse update(Integer id, EmployeeRequest employeeRequest) {
        try {

            EmployeeType employeeType = employeeTypeRepository.findById(employeeRequest.employeeTypeId()).get();

            Enterprise enterprise = enterpriseRepository.findById(employeeRequest.enterpriseId()).get();
            Employee employee = employeeRepository.findById(id).get();
            employee.setName(employeeRequest.name() != null ? employeeRequest.name() : employee.getName());
            employee.setLastname(
                    employeeRequest.lastname() != null ? employeeRequest.lastname() : employee.getLastname());
            employee.setCpf(employeeRequest.cpf() != null ? employeeRequest.cpf() : employee.getCpf());
            employee.setEmail(employeeRequest.email() != null ? employeeRequest.email() : employee.getEmail());
            employee.setPhone(employeeRequest.phone() != null ? employeeRequest.phone() : employee.getPhone());
            employee.setDateBirth(
                    employeeRequest.dateBirth() != null ? employeeRequest.dateBirth() : employee.getDateBirth());
            employee.setImgUrl(employeeRequest.imgUrl() != null ? employeeRequest.imgUrl() : employee.getImgUrl());
            employee.setPassword(
                    employeeRequest.password() != null ? employeeRequest.password() : employee.getPassword());
            employee.setNickname(
                    employeeRequest.nickname() != null ? employeeRequest.nickname() : employee.getNickname());
            employee.setActive(employeeRequest.active() != null ? employeeRequest.active() : employee.getActive());
            employee.setEnterprise(enterprise != null ? enterprise : employee.getEnterprise());
            employee.setEmployeeType(employeeType != null ? employeeType : employee.getEmployeeType());

            return employeeMapper.toResponse(employeeRepository.save(employee));
        } catch (Exception e) {
            throw new RuntimeException("Error to update employee");
        }
    }

    public void active(Integer id) {
        try {
            Employee employee = employeeRepository.findById(id).get();
            if (employee == null) {
                throw new NullPointerException("Employee not found");

            }

            employee.setActive(true);
            employeeRepository.save(employee);
        } catch (Exception e) {
            throw new RuntimeException("Error to active employee");
        }
    }


    public void delete(Integer id) {
        try {
            Employee employee = employeeRepository.findById(id).get();
            if (employee == null) {
                throw new NullPointerException("Employee not found");

            }

            if (employee.getActive()) {
                employee.setActive(false);
                employeeRepository.save(employee);
            } else {
                employeeRepository.deleteById(id);

            }
        } catch (Exception e) {
            throw new RuntimeException("Error to delete employee");
        }
    }

}
