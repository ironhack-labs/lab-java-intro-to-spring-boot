package com.ironhack.lab402.controller.impl;

import com.ironhack.lab402.controller.interfaces.IEmployeeController;
import com.ironhack.lab402.model.Employee;
import com.ironhack.lab402.model.Status;
import com.ironhack.lab402.service.interfaces.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController implements IEmployeeController {

    @Autowired
    IEmployeeService employeeService;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/id/{employeeId}")
    @ResponseStatus(HttpStatus.OK)
    public Employee getEmployeeById(@PathVariable Integer employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    @GetMapping("/status")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getEmployeesByStatus(@RequestParam Status status) {
        return employeeService.getEmployeesByStatus(status);
    }

    @GetMapping("/department")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getEmployeesByDepartment(@RequestParam String department) {
        return employeeService.getEmployeesByDepartment(department);
    }
}
