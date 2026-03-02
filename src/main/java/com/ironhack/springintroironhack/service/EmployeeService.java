package com.ironhack.springintroironhack.service;

import com.ironhack.springintroironhack.dto.EmployeeResponse;
import com.ironhack.springintroironhack.entity.EmployeeEntity;
import com.ironhack.springintroironhack.mapper.EmployeeMapper;
import com.ironhack.springintroironhack.model.Department;
import com.ironhack.springintroironhack.model.EmployeeStatus;
import com.ironhack.springintroironhack.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    public List<EmployeeResponse> getAll() {
        List<EmployeeEntity> employees = employeeRepository.findAll();
        return employees.stream()
                .map(employeeMapper::toResponse).toList();
    }

    public EmployeeResponse getById(Long id) {
        EmployeeEntity employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee with id " + id + " not found"));
        return employeeMapper.toResponse(employee);
    }

    public List<EmployeeResponse> getByStatus(EmployeeStatus status) {
        List<EmployeeEntity> employees = employeeRepository.findByStatus(status);
        return employees.stream()
                .map(employeeMapper::toResponse).toList();
    }

    public List<EmployeeResponse> getByDepartment(Department department) {
        List<EmployeeEntity> employees = employeeRepository.findByDepartment(department);
        return employees.stream()
                .map(employeeMapper::toResponse).toList();
    }
}
