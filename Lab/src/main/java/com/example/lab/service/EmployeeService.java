package com.example.lab.service;

import com.example.lab.exception.ResourceNotFoundException;
import com.example.lab.model.Employee;
import com.example.lab.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    public List<Employee> getAllDoctors(){
       return employeeRepository.findAll();
    }
    public Employee getDoctorById(Long id){
        return employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee with this id not found"));
    }
    public  List<Employee> getDoctorsByStatus(String status){
        return employeeRepository.findByStatus(status).orElseThrow(()-> new ResourceNotFoundException("Employees with this status not found"));
    }
    public List<Employee>  getDoctorsByDepartment(String department){
        return  employeeRepository.findByDepartment(department).orElseThrow(()-> new ResourceNotFoundException("Employees with this department not found"));
    }

}
