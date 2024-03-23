package com.gets.service;

import com.gets.Enums.Status;
import com.gets.model.Employee;
import com.gets.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    public Optional<Employee> getEmployeeById(int id) {
        return employeeRepo.findById(id);
    }

    public List<Employee> getEmployeeByStatus(Status status) {
        return employeeRepo.findByStatus(status);
    }

    public List<Employee> getEmployeeByDepartment(String department) {
        return employeeRepo.findByDepartment(department);
    }
}
