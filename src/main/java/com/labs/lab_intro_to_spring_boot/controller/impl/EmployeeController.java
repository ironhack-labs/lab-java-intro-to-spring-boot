package com.labs.lab_intro_to_spring_boot.controller.impl;

import com.labs.lab_intro_to_spring_boot.controller.interfaces.IEmployeeController;
import com.labs.lab_intro_to_spring_boot.model.Employee;
import com.labs.lab_intro_to_spring_boot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController implements IEmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/doctors")
    public List<Employee> getAllDoctors() {
        return employeeRepository.findAll();
    }

    @GetMapping("/doctor/{employeeId}")
    public Employee getDoctorById(@PathVariable Long employeeId) {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
        if (employeeOptional.isEmpty()) return null;
        return employeeOptional.get();
    }

    @GetMapping("/doctorsByDepartment")
    public List<Employee> getDoctorsByDepertment(@RequestParam String department) {
        return employeeRepository.findByDepartment(department);
    }

    @GetMapping("/doctorsByStatus")
    public List<Employee> getDoctorsByStatus(@RequestParam String status) {
        return employeeRepository.findByStatus(status);

    }
}

