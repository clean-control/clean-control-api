package com.example.cleancontrol.api.service;

import lombok.RequiredArgsConstructor;
import java.util.*;

import org.springframework.stereotype.Service;

import com.example.cleancontrol.api.dto.employeeDto.EmployeeRequest;
import com.example.cleancontrol.api.mapper.EmployeeMapper;
import com.example.cleancontrol.domain.model.Employee;
import com.example.cleancontrol.domain.model.EmployeeType;
import com.example.cleancontrol.domain.model.Enterprise;
import com.example.cleancontrol.domain.model.Users;
import com.example.cleancontrol.domain.repository.EmployeeRepository;
import com.example.cleancontrol.domain.repository.EmployeeTypeRepository;
import com.example.cleancontrol.domain.repository.EnterpriseRepository;
import com.example.cleancontrol.domain.repository.UserRepository;
import com.example.cleancontrol.domain.repository.UserTypeRepository;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;


    private final EmployeeTypeRepository employeeTypeRepository;

    private final EnterpriseRepository enterpriseRepository;

    private final UserRepository userRepository;
    private final UserTypeRepository userTypeRepository;

    public List<Employee> findAll() {
        try {

            List<Employee> employees = new ArrayList<Employee>();

            for (Employee employee : employeeRepository.findAll()) {

                employees.add(employee);

            }

            return employees;
        } catch (Exception e) {
            throw new RuntimeException("Error to get employees");
        }
    }

    public Employee findById(Integer id) {
        try {
            Employee employee = employeeRepository.findById(id).get();
            return employee;
        } catch (Exception e) {
            throw new RuntimeException("Error to get employee");
        }
    }

    public Employee save(EmployeeRequest employeeRequest) {
        try {

            EmployeeType employeeType = employeeTypeRepository.findById(employeeRequest.employeeTypeId()).get();
            Enterprise enterprise = enterpriseRepository.findById(employeeRequest.enterpriseId()).get();
            Users user = Users.builder()
                    .name(employeeRequest.name())
                    .lastname(employeeRequest.lastname())
                    .cpf(employeeRequest.cpf())
                    .email(employeeRequest.email())
                    .phone(employeeRequest.phone())
                    .dateBirth(employeeRequest.dateBirth())
                    .imgUrl(employeeRequest.imgUrl())
                    .password(employeeRequest.password())
                    .nickname(employeeRequest.nickname())
                    .active(employeeRequest.active())
                    .userType(userTypeRepository.findByName("Employee"))
                    .build();

            userRepository.save(user);

            Employee employee = Employee.builder()
                    .user(user)
                    .enterprise(enterprise)
                    .employeeType(employeeType)
                    .build();

            employeeRepository.save(employee);

            return employee;
        } catch (Exception e) {
            throw new RuntimeException("Error to save employee");
        }
    }

    public Employee update(Integer id, EmployeeRequest employeeRequest) {
        try {

            EmployeeType employeeType = employeeTypeRepository.findById(employeeRequest.employeeTypeId()).get();

            Enterprise enterprise = enterpriseRepository.findById(employeeRequest.enterpriseId()).get();
            Employee employee = employeeRepository.findById(id).get();
            employee.getUser()
                    .setName(employeeRequest.name() != null ? employeeRequest.name() : employee.getUser().getName());
            employee.getUser().setLastname(
                    employeeRequest.lastname() != null ? employeeRequest.lastname() : employee.getUser().getLastname());
            employee.getUser()
                    .setCpf(employeeRequest.cpf() != null ? employeeRequest.cpf() : employee.getUser().getCpf());
            employee.getUser().setEmail(
                    employeeRequest.email() != null ? employeeRequest.email() : employee.getUser().getEmail());
            employee.getUser().setPhone(
                    employeeRequest.phone() != null ? employeeRequest.phone() : employee.getUser().getPhone());
            employee.getUser().setDateBirth(
                    employeeRequest.dateBirth() != null ? employeeRequest.dateBirth()
                            : employee.getUser().getDateBirth());
            employee.getUser().setImgUrl(
                    employeeRequest.imgUrl() != null ? employeeRequest.imgUrl() : employee.getUser().getImgUrl());
            employee.getUser().setPassword(
                    employeeRequest.password() != null ? employeeRequest.password() : employee.getUser().getPassword());
            employee.getUser().setNickname(
                    employeeRequest.nickname() != null ? employeeRequest.nickname() : employee.getUser().getNickname());
            employee.getUser().setActive(
                    employeeRequest.active() != null ? employeeRequest.active() : employee.getUser().getActive());
            employee.setEnterprise(enterprise != null ? enterprise : employee.getEnterprise());
            employee.setEmployeeType(employeeType != null ? employeeType : employee.getEmployeeType());

            employeeRepository.save(employee);

            return employee;
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

            employee.getUser().setActive(true);
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

            if (employee.getUser().getActive()) {
                employee.getUser().setActive(false);
                employeeRepository.save(employee);
            } else {
                employeeRepository.deleteById(id);

            }
        } catch (Exception e) {
            throw new RuntimeException("Error to delete employee");
        }
    }

}
