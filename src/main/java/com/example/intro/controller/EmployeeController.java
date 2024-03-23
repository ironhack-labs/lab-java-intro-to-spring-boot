package com.example.intro.controller;

import com.example.intro.model.Employee;
import com.example.intro.model.utils.Status;
import com.example.intro.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees/byDepartment/{department}")
    public List<Employee> getEmployeeByStatus(@PathVariable(name = "department") String department) {
        return employeeService.findByDepartment(department);
    }

    @GetMapping("/employees/byStatus/{status}")
    public List<Employee> getEmployeeByStatus(@PathVariable(name = "status") Status status) {
        return employeeService.findByStatus(status);
    }
    @GetMapping("/employees/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable(name = "id") int employeeId) {
        return employeeService.findById(employeeId);
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.findAll();
    }
}
