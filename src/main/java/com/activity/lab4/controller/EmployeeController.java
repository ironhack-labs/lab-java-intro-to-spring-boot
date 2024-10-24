package com.activity.lab4.controller;


import ch.qos.logback.core.status.Status;
import com.activity.lab4.model.Employee;
import com.activity.lab4.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long ID) {
        return employeeService.getEmployeeById(ID);
    }

    @GetMapping("/status/{status}")
    public List<Employee> getEmployeeByStatus(@PathVariable Status status) {
        return employeeService.getEmployeesByStatus(status);

    }

    @GetMapping("/department/{department}")
    public List<Employee> getEmployeeByDepartment(@PathVariable String department) {
        return employeeService.getEmployeesByDepartment(department);
    }
}
