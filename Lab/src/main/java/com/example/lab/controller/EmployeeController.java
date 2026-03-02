package com.example.lab.controller;

import com.example.lab.model.Employee;
import com.example.lab.repository.EmployeeRepository;
import com.example.lab.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/doctors")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    @GetMapping
    public List<Employee> getAllDoctors(){
        return employeeService.getAllDoctors();
    }
    @GetMapping("/id/{id}")
    public Employee getDoctorById(@PathVariable long id){
        return employeeService.getDoctorById(id);
    }
    @GetMapping("/status/{status}")
    public List<Employee> getDoctorsByStatus(@PathVariable String status){
        return employeeService.getDoctorsByStatus(status);
    }
    @GetMapping("/department/{department}")
    public List<Employee> getDoctorsByDepartment(@PathVariable String department){
        return employeeService.getDoctorsByDepartment(department);
    }
}
