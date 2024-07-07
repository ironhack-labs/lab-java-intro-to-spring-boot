package com.example.lab_java_intro_to_spring_boot.controller.input;

import com.example.lab_java_intro_to_spring_boot.controller.interfaces.IEmployeeController;
import com.example.lab_java_intro_to_spring_boot.model.Employee;
import com.example.lab_java_intro_to_spring_boot.model.Status;
import com.example.lab_java_intro_to_spring_boot.repository.EmployeeRepository;
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

    @GetMapping("/employee")
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

   @GetMapping("/employee/{id}")
    public Employee getEmployeeId(@PathVariable Integer id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isEmpty()) return null;
        return employeeOptional.get();
    }

    @GetMapping("/employee/{status}")
    public List<Employee> getEmployeeByStatus(Status status){
        return employeeRepository.findAllByStatus(status);
    }

    @GetMapping("/employee/{department}")
    public List<Employee> getEmployeeByDepartment(String department) {
        return employeeRepository.findAllByDepartment(department);
    }
}