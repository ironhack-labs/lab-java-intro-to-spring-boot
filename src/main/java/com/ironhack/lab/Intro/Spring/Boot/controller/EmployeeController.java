package com.ironhack.lab.Intro.Spring.Boot.controller;

import com.ironhack.lab.Intro.Spring.Boot.model.Employee;
import com.ironhack.lab.Intro.Spring.Boot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable String id) {
        return employeeService.findById(id);
    }

    @GetMapping("/department/{department}")
    public List<Employee> findAllByDepartment(@PathVariable String department){
        return employeeService.findAllByDepartment(department);
    }

    @GetMapping("/status/{status}")
    public List<Employee> findAllByStatus(@PathVariable String status){
        return employeeService.findAllByStatus(status);
    }

}
