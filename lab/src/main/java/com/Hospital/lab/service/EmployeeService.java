package com.Hospital.lab.service;


import com.Hospital.lab.model.Employee;
import com.Hospital.lab.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List getAllDoctors() {
        return repository.findAll();
    }

    public Employee getDoctorById(Long id) {
        return (Employee) repository.findById(id).orElse(null);
    }

    public List getDoctorsByStatus(String status) {
        return repository.findByStatus(status);
    }

    public List getDoctorsByDepartment(String department) {
        return repository.findByDepartment(department);
    }
}
