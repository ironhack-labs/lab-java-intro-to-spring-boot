package com.ironhack.demo.service;

import com.ironhack.demo.enums.Department;
import com.ironhack.demo.enums.Status;
import com.ironhack.demo.model.Employee;
import com.ironhack.demo.repository.EmployeeRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllDoctors(){
        return employeeRepository.findAll();
    }

    public Employee getDoctorById(Long employeeId){
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with employee ID: " + employeeId));
    }

    public List<Employee> getDoctorsByStatus(Status status){
        return employeeRepository.findAllByStatus(status);
    }

    public List<Employee> getDoctorsByDepartment(Department department){
        return employeeRepository.findAllByDepartment(department);
    }
}
