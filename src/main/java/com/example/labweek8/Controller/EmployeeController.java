package com.example.labweek8.Controller;

import com.example.labweek8.Model.Employee;
import com.example.labweek8.Service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/all")
    public List<Employee> getEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")

    public Employee getEmployeeById(@PathVariable(name = "id") int id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("status")
    public List<Employee> getEmployeeByStatus(@RequestParam String status) {
        return employeeService.getEmployeeByStatus(status);
    }

    @GetMapping("department")
    public List<Employee> getEmployeeByDepartment(@RequestParam String department) {
        return employeeService.getEmployeeByDepartment(department);
    }

}
