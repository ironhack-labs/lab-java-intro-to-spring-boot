package com.ironhack.lab402.service.impl;

import com.ironhack.lab402.model.Employee;
import com.ironhack.lab402.model.Status;
import com.ironhack.lab402.repository.EmployeeRepository;
import com.ironhack.lab402.service.interfaces.IEmployeeService;
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
    public Employee getEmployeeById(Integer employeeId) {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
        return employeeOptional.get();
    }

    @Override
    public List<Employee> getEmployeesByStatus(Status status) {
        return employeeRepository.findAllByStatus(status);
    }

    @Override
    public List<Employee> getEmployeesByDepartment(String department) {
        return employeeRepository.findAllByDepartment(department);
    }
}
