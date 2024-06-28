package com.ironhack.week9lab.controller;

import com.ironhack.week9lab.model.Employee;
import com.ironhack.week9lab.model.EmployeeStatus;
import com.ironhack.week9lab.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctors")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public List<Employee> findAll() {
        return employeeService.getAllEmployees();

    }

    @GetMapping("/{id}")
    public Optional<Employee> findById(@PathVariable int id) {
        return employeeService.getEmployeeId(id);
    }

    @GetMapping("/status/{status}")
    public List<Employee> findByStatus(@PathVariable EmployeeStatus status) {
        return employeeService.getEmployeeStatus(status);
    }

    @GetMapping("/department/{department}")
    public List<Employee> findByDepartment(@PathVariable String department) {
        return employeeService.getEmployeesByDepartment(department);
    }



}
