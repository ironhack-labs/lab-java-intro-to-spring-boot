package com.ironhack.multicityhospital2.service;


import com.ironhack.multicityhospital2.model.Employee;
import com.ironhack.multicityhospital2.repository.EmployeeRepository;
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
        log.info("Get all employees");
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long employeeId) {
        log.info("Get employee by Id {}", employeeId);
        return employeeRepository.findById(employeeId);
    }
    public Optional<Employee> getEmployeeByStatus(String status) {
        log.info("Get employee by status {}", status);
        return employeeRepository.findByStatus(status);
    }
    public Optional<Employee> getEmployeeByDepartment(String department){
        log.info("Get employee by department");
        return employeeRepository.findByDepartment(department);
    }

    public Employee addNewEmployee(Employee employee){
        log.info("adding new employee {}", employee);
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long employeeId){
        log.info("Removing employee with id {}", employeeId);

        employeeRepository.deleteById(employeeId);
    }
}

