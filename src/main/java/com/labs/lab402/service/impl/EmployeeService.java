package com.labs.lab402.service.impl;

import com.labs.lab402.model.Employee;
import com.labs.lab402.model.STATUS;
import com.labs.lab402.repository.EmployeeRepository;
import com.labs.lab402.service.interfaces.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(String id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(Integer.parseInt(id));
        if (employeeOptional.isEmpty()) return null;
        return employeeOptional.get();
    }

    @Override
    public List<Employee> getAllEmployeesByStatus(STATUS status) {
        return employeeRepository.findAllByStatus(status);
    }

    @Override
    public List<Employee> getAllEmployeesByDepartment(String department) {
        return employeeRepository.findAllByDepartment(department);
    }
}
