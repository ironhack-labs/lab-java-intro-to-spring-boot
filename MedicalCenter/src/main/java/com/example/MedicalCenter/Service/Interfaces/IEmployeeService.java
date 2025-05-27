package com.example.MedicalCenter.Service.Interfaces;

import com.example.MedicalCenter.Model.EmployeeStatus;

import com.example.MedicalCenter.Model.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id);

    List<Employee> getEmployeesByStatus(EmployeeStatus status);

    List<Employee> getEmployeesByDepartment(String department);


}