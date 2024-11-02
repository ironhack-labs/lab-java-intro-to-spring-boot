package com.example.springbootlab.service;

import com.example.springbootlab.model.Employee;
import com.example.springbootlab.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllDoctors() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getDoctorById(Long id) {
        return employeeRepository.findById(id);
    }

    public List<Employee> getDoctorsByStatus(String status) {
        return employeeRepository.findByStatus(status);
    }

    public List<Employee> getDoctorsByDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }
}