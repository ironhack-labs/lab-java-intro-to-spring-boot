package com.springBoot.service;


import com.springBoot.enums.StatusOfEmployee;
import com.springBoot.model.Employee;
import com.springBoot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() { return employeeRepository.findAll(); }

    public Optional<Employee> getEmployeeById(Long id) { return employeeRepository.findById(id); }

    public List<Employee> getEmployeesByStatus(StatusOfEmployee status){
        return employeeRepository.findByStatus(status);
    }

    public List<Employee> getEmployeesByDepartment(String department){
        return employeeRepository.findByDepartment(department);
    }
}
