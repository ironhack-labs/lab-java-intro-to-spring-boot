package com.ironhack.week9_lab.Controller;

import com.ironhack.week9_lab.Services.EmployeeService;
import com.ironhack.week9_lab.enums.Status;
import com.ironhack.week9_lab.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/id/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/status/{status}")
    public List<Employee> getEmployeeById(@PathVariable String status) {

            Status employeeStatus = Status.valueOf(status.toUpperCase());
            List<Employee> employees = employeeService.getEmpployeeByStatus(employeeStatus);
            return employees;

    }


    @GetMapping("/department/{department}")
    public List<Employee> getEmployeeByDepartment(@PathVariable String department) {
        return employeeService.getEmployeeByDepartment(department);
    }




}
