package com.ironhack.labjavaintrotospringboot.controller;

import com.ironhack.labjavaintrotospringboot.enums.StatusEnum;
import com.ironhack.labjavaintrotospringboot.model.Employee;
import com.ironhack.labjavaintrotospringboot.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctors")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllDoctors() {
        return employeeService.getAllDoctors();
    }

    @GetMapping("/{id}")
    public Optional<Employee> getDoctorByID(@PathVariable("id") int employeeId) {
        return employeeService.getDoctorByID(employeeId);
    }

    @GetMapping("/status/{status}")
    public List<Employee> getDoctorsByStatus(@PathVariable("status") StatusEnum status) {
        return employeeService.getDoctorsByStatus(status);
    }

    @GetMapping("department/{department}")
    public List<Employee> getDoctorsByDepartment(@PathVariable("department") String department) {
        return employeeService.getDoctorsByDepartment(department);
    }
}
