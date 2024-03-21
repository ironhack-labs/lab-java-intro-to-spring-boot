package com.example.demo.Services;

import com.example.demo.Classes.Employee;
import com.example.demo.Repositories.EmployeeRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public List<Employee> getDoctorsByStatus(String status) {
        return employeeRepository.findByStatus(status);
    }

    public List<Employee> getDoctorsByDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }
}
