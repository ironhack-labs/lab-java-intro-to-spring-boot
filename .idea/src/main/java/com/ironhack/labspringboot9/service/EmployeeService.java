package com.ironhack.labspringboot9.service;

import com.ironhack.labspringboot9.enums.Status;
import com.ironhack.labspringboot9.model.Employee;
import com.ironhack.labspringboot9.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();

    }
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).get();
    }
    public List<Employee> getEmployeeByStatus(Status status) {
        return employeeRepository.findByStatus(status);
    }
    public List<Employee>getAllDoctorsByDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }
}
