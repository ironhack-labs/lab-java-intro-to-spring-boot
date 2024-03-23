package com.lab402.demo.controller;

import com.lab402.demo.model.Employee;
import com.lab402.demo.model.Status;
import com.lab402.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> findAllDoctors() {
        return employeeService.findAllDoctors();
    }
    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        return employeeService.addNewEmployee(employee);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") Integer employeeId){
        employeeService.deleteEmployeeById(employeeId);
        return ResponseEntity.ok("Employee deleted sucessfully");
    }

    @GetMapping("/employees/{id}")
    public Optional<Employee> findDoctorById(@PathVariable(name="id") Integer employeeId) {
        return employeeService.findDoctorById(employeeId);
    }

    @GetMapping("/employees/status")
    public List<Employee> finDoctorsByStatus(@RequestParam Status status) {
        return employeeService.findDoctorsByStatus(status);
    }

    @GetMapping("/employees/departments")
    public List<Employee> finDoctorsByDepartments(@RequestParam String department) {
        return employeeService.findDoctorsByDepartment(department);
    }


}
