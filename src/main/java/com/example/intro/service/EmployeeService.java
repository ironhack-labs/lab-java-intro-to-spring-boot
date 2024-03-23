package com.example.intro.service;

import com.example.intro.model.Employee;
import com.example.intro.model.utils.Status;
import com.example.intro.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> findById(int employeeId) {
        return employeeRepository.findById(employeeId);
    }

    public List<Employee> findByStatus(Status status) {
        return employeeRepository.findByStatus(status);
    }

    public List<Employee> findByDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }
}
