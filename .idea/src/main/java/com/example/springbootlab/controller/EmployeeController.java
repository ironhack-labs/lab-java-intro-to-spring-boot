package com.example.springbootlab.controller;

import com.example.springbootlab.model.Employee;
import com.example.springbootlab.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllDoctors() {
        return employeeService.getAllDoctors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getDoctorById(@PathVariable Long id) {
        return employeeService.getDoctorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
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