package com.example.introjpa.demo.service;

import com.example.introjpa.demo.model.Employee;
import com.example.introjpa.demo.model.Status;
import com.example.introjpa.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addNewEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    public Employee findByEmployeeId(Integer id){
        return employeeRepository.findByEmployeeId(id);
    }

    public List<Employee> findByEmployeeStatus(Status status){
        return employeeRepository.findAllByStatus(status);
    }

    public List<Employee> findByDepartment(String department){
        return employeeRepository.findAllByDepartment(department);
    }
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
}
