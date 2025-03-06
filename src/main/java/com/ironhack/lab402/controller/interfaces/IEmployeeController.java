package com.ironhack.lab402.controller.interfaces;

import com.ironhack.lab402.model.Employee;
import com.ironhack.lab402.model.Status;

import java.util.List;

public interface IEmployeeController {

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Integer employeeId);

    List<Employee> getEmployeesByStatus(Status status);

    List<Employee> getEmployeesByDepartment(String department);
}
