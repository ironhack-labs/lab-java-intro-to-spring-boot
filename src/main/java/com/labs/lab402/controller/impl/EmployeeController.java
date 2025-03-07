package com.labs.lab402.controller.impl;

import com.labs.lab402.controller.interfaces.IEmployeeController;
import com.labs.lab402.model.Employee;
import com.labs.lab402.model.STATUS;
import com.labs.lab402.service.interfaces.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("/cool")
public class EmployeeController implements IEmployeeController {

    @Autowired
    IEmployeeService employeeService;

    @GetMapping("/employees")
    @Override
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employee/{id}")
    @Override
    public Employee getEmployeeById(@PathVariable String id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/employee/status/{status}")
    @Override
    public List<Employee> getAllEmployeesByStatus(@PathVariable STATUS status) {
        return employeeService.getAllEmployeesByStatus(status);
    }

    @GetMapping("/employee/department/{department}")
    @Override
    public List<Employee> getAllEmployeesByDepartment(@PathVariable String department) {
        return employeeService.getAllEmployeesByDepartment(department);
    }
}
