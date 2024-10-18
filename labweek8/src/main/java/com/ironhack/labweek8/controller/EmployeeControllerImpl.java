package com.ironhack.labweek8.controller;

import com.ironhack.labweek8.model.Employee;
import com.ironhack.labweek8.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/employees")
public class EmployeeControllerImpl implements EmployeeControllerInterface {

  private final EmployeeService employeeService;

  @GetMapping("/all")
  @ResponseStatus(HttpStatus.OK)
  public List<Employee> getEmployees() {
    return employeeService.getAllEmployees();
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Employee getEmployeeById(@PathVariable(name = "id") int id) {
    return employeeService.getEmployeeById(id);
  }

  @GetMapping("status")
  public List<Employee> getEmployeeByStatus(@RequestParam String status) {
    return employeeService.getEmployeeByStatus(status);
  }

  @GetMapping("department")
  public List<Employee> getEmployeeByDepartment(@RequestParam String department) {
    return employeeService.getEmployeeByDepartment(department);
  }
}