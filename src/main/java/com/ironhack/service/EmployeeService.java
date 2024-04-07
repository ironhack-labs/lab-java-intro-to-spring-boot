package com.ironhack.service;

import com.ironhack.model.Employee;
import com.ironhack.model.enums.Status;
import com.ironhack.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> searchByEmployeeId(int employeeId) {
        return employeeRepository.findByEmployeeId(employeeId);
    }

    public List<Employee> getAllByStatus(Status status) {
        return employeeRepository.findAllByStatus(status);
    }

    public List<Employee> getAllByDepartment(String department) {
        return employeeRepository.findAllByDepartment(department);
    }
}