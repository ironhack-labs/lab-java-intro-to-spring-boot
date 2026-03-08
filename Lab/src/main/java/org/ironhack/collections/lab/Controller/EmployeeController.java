package org.ironhack.collections.lab.Controller;

import org.ironhack.collections.lab.Model.Employee;
import org.ironhack.collections.lab.Service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getDoctors() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getDoctorsById(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/status/{status}")
    public List<Employee> getDoctorsByStatus(@PathVariable String status) {
        return employeeService.getDoctorsByStatus(status);
    }

    @GetMapping("/department/{department}")
    public List<Employee> getDoctorsByDepartment(@PathVariable String department) {
        return employeeService.getDoctorsByDepartment(department);
    }
}