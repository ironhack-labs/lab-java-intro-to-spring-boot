package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.HospitalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing hospital employees (doctors).
 */
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final HospitalService hospitalService;

    @Autowired
    public EmployeeController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

//    Give you all employees data
    @GetMapping
    public List<Employee> getAllEmployees() {
        return hospitalService.getAllEmployees();
    }
// Give you employee acording to ID
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return hospitalService.getEmployeeById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
// Give you employee according to Status
    @GetMapping("/status/{status}")
    public List<Employee> getByStatus(@PathVariable String status) {
        return hospitalService.getEmployeesByStatus(status);
    }
// Give you employee acording to department
    @GetMapping("/department/{department}")
    public List<Employee> getByDepartment(@PathVariable String department) {
        return hospitalService.getEmployeesByDepartment(department);
    }


}