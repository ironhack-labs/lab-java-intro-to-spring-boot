package com.ironhack.lab402.service.interfaces;

import com.ironhack.lab402.model.Employee;
import com.ironhack.lab402.model.Status;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Integer employeeId);

    List<Employee> getEmployeesByStatus(Status status);

    List<Employee> getEmployeesByDepartment(String department);
}
