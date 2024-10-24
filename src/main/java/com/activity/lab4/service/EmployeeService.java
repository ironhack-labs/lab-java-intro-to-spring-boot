package com.activity.lab4.service;


import ch.qos.logback.core.status.Status;
import com.activity.lab4.model.Employee;
import com.activity.lab4.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;

    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long ID) {
        return employeeRepository.findById(ID).get();

    }

    public List<Employee> getEmployeesByStatus(Status status) {
        return employeeRepository.findByStatus(status);

    }

    public List<Employee> getEmployeesByDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }
}
