package com.example.MedicalCenter.Controller.implem;

import com.example.MedicalCenter.Model.EmployeeStatus;
import com.example.MedicalCenter.Model.Employee;
import com.example.MedicalCenter.Service.Interfaces.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")

public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/employees/status/{status}")
    public List<Employee> getEmployeesByStatus(@PathVariable("status") EmployeeStatus status) {
        return employeeService.getEmployeesByStatus(status);
    }

    @GetMapping("/employees/department/{department}")
    public List<Employee> getEmployeesByDepartment(@PathVariable String department) {
        return employeeService.getEmployeesByDepartment(department);
    }


}
