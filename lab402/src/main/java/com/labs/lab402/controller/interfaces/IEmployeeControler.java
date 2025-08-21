package com.labs.lab402.controller.interfaces;

import com.labs.lab402.model.Employee;

import java.util.List;

public interface IEmployeeControler {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long employeeId);
    List<Employee> getEmployeesByStatus(String status);
    List<Employee> getEmployeesByDepartment(String department);
}
