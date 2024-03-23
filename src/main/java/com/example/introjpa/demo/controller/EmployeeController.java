package com.example.introjpa.demo.controller;

import com.example.introjpa.demo.model.Employee;
import com.example.introjpa.demo.model.Status;
import com.example.introjpa.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employee")
    public List<Employee> getAllEmployee(){
        return employeeService.findAll();
    }

    @GetMapping("/employee/{id}")
    public Employee getByDoctorId(@RequestParam(name = "employee_id") Integer id){
        return employeeService.findByEmployeeId(id);
    }

    @GetMapping("/employee/status")
    public List<Employee> findByDoctorStatus(@RequestParam(name = "status")Status status){
        return employeeService.findByEmployeeStatus(status);
    }

    @GetMapping("/employee/department")
    public List<Employee> getAllByDepartment(@RequestParam(name = "department") String department){
        return employeeService.findByDepartment(department);
    }

    @PostMapping("/employee")
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeService.addNewEmployee( employee);
    }

}
