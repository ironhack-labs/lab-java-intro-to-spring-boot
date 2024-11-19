package com.Hospital.lab.controller;


import com.example.hospital.model.Employee;
import com.example.hospital.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Employee> getAllDoctors() {
        return service.getAllDoctors();
    }

    @GetMapping("/{id}")
    public Employee getDoctorById(@PathVariable Long id) {
        return service.getDoctorById(id);
    }

    @GetMapping("/status/{status}")
    public List<Employee> getDoctorsByStatus(@PathVariable String status) {
        return service.getDoctorsByStatus(status);
    }

    @GetMapping("/department/{department}")
    public List<Employee> getDoctorsByDepartment(@PathVariable String department) {
        return service.getDoctorsByDepartment(department);
    }
}
