package com.ironhack.labweek8.service;

import com.ironhack.labweek8.model.Employee;
import com.ironhack.labweek8.model.EmployeeStatus;
import com.ironhack.labweek8.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        //return optional.orElse(null);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    public List<Employee> getEmployeeByStatus(String status) {
        return employeeRepository.findEmployeeByStatus(EmployeeStatus.valueOf(status.toUpperCase()));
    }

    public List<Employee> getEmployeeByDepartment(String department) {
        return employeeRepository.findEmployeeByDepartment(department);
    }
}
