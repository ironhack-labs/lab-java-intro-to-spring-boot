package com.gets.controller;

import com.gets.Enums.Status;
import com.gets.model.Employee;
import com.gets.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/employee/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Employee> getEmployeeById(@PathVariable(name="id") int id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/employees/status/{status}")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getEmployeeByStatus(@PathVariable(name="status")Status status) {
        return employeeService.getEmployeeByStatus(status);
    }

    @GetMapping("/employees/department/{department}")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getEmployeeByDepartment(@PathVariable(name="department")String department) {
        return employeeService.getEmployeeByDepartment(department);
    }

}
