package com.hospital.hospitalmanagment.Services;

import com.hospital.hospitalmanagment.model.Employee;
import com.hospital.hospitalmanagment.model.Patient;
import com.hospital.hospitalmanagment.model.Status;
import com.hospital.hospitalmanagment.repositories.EmployeeRepository;
import com.hospital.hospitalmanagment.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(int id) {
        return  employeeRepository.findById(id);
    }

    public List<Employee> getEmployeeByStatus(Status status) {
        return employeeRepository.findByStatus(status);
    }

    public List<Employee> getEmployeeByDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }
}
