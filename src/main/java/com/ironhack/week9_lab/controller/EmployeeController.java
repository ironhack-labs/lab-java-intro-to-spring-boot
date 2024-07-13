package com.ironhack.week9_lab.controller;


import ch.qos.logback.core.status.Status;
import com.ironhack.week9_lab.model.Employee;
import com.ironhack.week9_lab.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctors")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployee(){
        return null;
    }
    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable long id) {
        return employeeService.getEmployeeById((int) id);
    }
    @GetMapping("/status/{status}")
    public List<Employee> getEmployeeByStatus(@PathVariable Status status) {
        return employeeService.getEmployeeByStatus(String.valueOf(status));
    }
    @GetMapping("/department/{department}")
    public List<Employee> findByDepartment(@PathVariable String department) {
     return employeeService.getEmployeeByDepartment(department);
    }


    }











