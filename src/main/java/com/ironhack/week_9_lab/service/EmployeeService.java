package com.ironhack.week_9_lab.service;

import com.ironhack.week_9_lab.model.Employee;
import com.ironhack.week_9_lab.model.EmployeeStatus;
import com.ironhack.week_9_lab.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(int id) {
        return employeeRepository.findById(id);
    }

    public List<Employee> getEmployeeByStatus(EmployeeStatus status) {
        return employeeRepository.findByStatus(status);
    }

    public List<Employee> getEmployeeByDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }
}
