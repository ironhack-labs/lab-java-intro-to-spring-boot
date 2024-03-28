package controller;

import model.Employee;
import model.EmployeeStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.EmployeeService;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/doctors")
    public List<Employee> getDoctors() {
        return employeeService.findAll();
    }

    @GetMapping("/doctors/{id}")
    public Optional<Employee> findByEmployeeId(@PathVariable int id) {
        return employeeService.findByEmployeeId(id);
    }

    @GetMapping("/doctors/department/{department}")
    public List<Employee> findByDepartment(@PathVariable String department) {
        return employeeService.findAllByDepartment(department);
    }

    @GetMapping("/doctors/status/{status}")
    public List<Employee> findByStatus(@PathVariable EmployeeStatus status) {
        return employeeService.findAllByStatus(status);
    }
}