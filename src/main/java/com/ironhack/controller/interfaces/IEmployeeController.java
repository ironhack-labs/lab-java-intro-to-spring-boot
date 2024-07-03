package com.ironhack.controller.interfaces;

import com.ironhack.model.Employee;

import java.util.List;

public interface IEmployeeController {
    public List<Employee> getAllEmployees();
    public Employee getEmployeeById(Integer id);
    public List<Employee> getAllEmployeesByDepartment(String department);
    public List<Employee> getAllEmployeesByStatus(String status);
}
