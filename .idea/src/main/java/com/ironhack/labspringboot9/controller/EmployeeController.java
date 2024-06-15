package com.ironhack.labspringboot9.controller;

import com.ironhack.labspringboot9.enums.Status;
import com.ironhack.labspringboot9.model.Employee;
import com.ironhack.labspringboot9.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }
    @GetMapping("/{status}")
    public List<Employee> getEmployeeByStatus(@PathVariable Status status) {
        return employeeService.getEmployeeByStatus(status);
    }
    @GetMapping("/{department}")
    public List<Employee> getEmployeeByDepartment(@RequestParam String department) {
        return employeeService.getAllDoctorsByDepartment(department);
    }

}
