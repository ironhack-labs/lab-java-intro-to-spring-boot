package com.ironhack.controller.impl;

import com.ironhack.controller.interfaces.IEmployeeController;
import com.ironhack.model.Employee;
import com.ironhack.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController implements IEmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable Integer id){
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        return employeeOptional.orElse(null);
    }

    @GetMapping("/employees/department/{department}")
    public List<Employee> getAllEmployeesByDepartment(@PathVariable String department){
        return employeeRepository.findAllByDepartment(department);
    }

    @GetMapping("/employees/status/{status}")
    public List<Employee> getAllEmployeesByStatus(@PathVariable String status){
        return employeeRepository.findAllByStatus(status);
    }

}
