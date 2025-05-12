package com.ironhack.hospital.controller.impl;

import com.ironhack.hospital.model.Employee;
import com.ironhack.hospital.model.Employee.Status;
import com.ironhack.hospital.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeesController {
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable Integer id) {
        Optional<Employee> EmployeeOptional = employeeRepository.findById(id);
        if (EmployeeOptional.isEmpty())
            return null;
        return EmployeeOptional.get();
    }

    @GetMapping("/employees/status/{status}")
    public ResponseEntity<Object> getEmployeeByStatus(@PathVariable Status status) {
        List<Employee> employees = employeeRepository.findByStatus(status);
        return employees.isEmpty() ? null : ResponseEntity.ok(employees);
    }

    @GetMapping("/employees/department/{department}")
    public ResponseEntity<Object> getEmployeeByDepartment(@PathVariable String department) {
        List<Employee> employees = employeeRepository.findByDepartment(department);
        return employees.isEmpty() ? null : ResponseEntity.ok(employees);
    }

}