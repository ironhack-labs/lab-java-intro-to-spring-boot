package com.ironhack.springboot.service;

import com.ironhack.springboot.model.Employee;
import com.ironhack.springboot.repository.EmployeeRepository;
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

    //    Get all doctors: Create a route to get all doctors.
    public List<Employee> getAllEmployees() {
        log.info("Getting all employees");
        return employeeRepository.getAllEmployees();
    }

    //    Get doctor by ID: Create a route to get a doctor by employee_id.
    public Optional<Employee> getEmployeeById(Long id) {
        log.info("Getting employee by id {}", id);
        return employeeRepository.findById(id);
    }

    //    Get doctors by status: Create a route to get doctors by status.
    public List<Employee> getEmployeesByStatus(String status) {
        log.info("Getting employees by status {}", status);
        return employeeRepository.getEmployeesByStatus(status);
    }

    //    Get doctors by department: Create a route to get doctors by department.
    public List<Employee> getEmployeesByDepartment(String department) {
        log.info("Getting employees by department {}", department);
        return employeeRepository.getEmployeesByDepartment(department);
    }
}
