package com.ironhack.week9lab.service;

import com.ironhack.week9lab.model.Employee;
import com.ironhack.week9lab.model.EmployeeStatus;
import com.ironhack.week9lab.repository.EmployeeRepository;
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
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Optional<Employee>getEmployeeId(int id){
        return employeeRepository.findById(id);
    }
    public List<Employee>getEmployeeStatus(EmployeeStatus status) {
        return employeeRepository.findByStatus( status);
    }

    public List<Employee>getEmployeesByDepartment(String department){
        return employeeRepository.findByDepartment(department);
    }
}
