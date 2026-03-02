package com.ironhack.springintroironhack.controller;

import com.ironhack.springintroironhack.dto.EmployeeResponse;
import com.ironhack.springintroironhack.model.Department;
import com.ironhack.springintroironhack.model.EmployeeStatus;
import com.ironhack.springintroironhack.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> getEmployee(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(employeeService.getById(id));
    }

    @GetMapping(params = {"status"})
    public ResponseEntity<List<EmployeeResponse>> getEmployeesByStatus(
            @RequestParam EmployeeStatus status
    ) {
        return ResponseEntity.ok(employeeService.getByStatus(status));
    }

    @GetMapping(params = {"department"})
    public ResponseEntity<List<EmployeeResponse>> getEmployeesByStatus(
            @RequestParam Department department
            ) {
        return ResponseEntity.ok(employeeService.getByDepartment(department));
    }
}
