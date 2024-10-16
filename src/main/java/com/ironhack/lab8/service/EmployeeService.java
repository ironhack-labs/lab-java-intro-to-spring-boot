package com.ironhack.lab8.service;

import com.ironhack.lab8.model.Employee;
import com.ironhack.lab8.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {


    private final EmployeeRepository employeeRepository;


    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    public List<Employee> setEmployees() {
        Employee employee = new Employee(356712L, "cardiology", "Alonso Flores", "ON_CALL");
        Employee employee2 = new Employee(564134L, "immunology", "Sam Ortega", "ON");
        Employee employee3 = new Employee(761527L, "cardiology", "German Ruiz", "OFF");
        Employee employee4 = new Employee(166552L, "pulmonary", "Maria Lin", "ON");
        Employee employee5 = new Employee(156545L, "orthopaedic", "Paolo Rodriguez", "ON_CALL");
        Employee employee6 = new Employee(172456L, "psychiatric", "John Paul Armes", "OFF");
        return employeeRepository.saveAll(List.of(employee, employee2, employee3, employee4, employee5, employee6));
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }


    public Employee getEmployeeById(long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public List<Employee> getEmployeeByStatus(String status) {
        return employeeRepository.findByStatus(status);

    }

    public List<Employee> getEmployeeByDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }

    public List <Employee> getAllEmployeesByStatusOff(String status) {
        return employeeRepository.findByStatus("OFF");
    }
}


