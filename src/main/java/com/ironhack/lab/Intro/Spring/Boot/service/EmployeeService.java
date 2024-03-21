package com.ironhack.lab.Intro.Spring.Boot.service;

import com.ironhack.lab.Intro.Spring.Boot.Enum.Department;
import com.ironhack.lab.Intro.Spring.Boot.Enum.Status;
import com.ironhack.lab.Intro.Spring.Boot.model.Employee;
import com.ironhack.lab.Intro.Spring.Boot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    public Employee findById(String id) {
        try {
            Optional<Employee> doctorFound = employeeRepository.findById(Long.parseLong(id));
            if (doctorFound.isPresent()) {
                return doctorFound.get();
            } else {
                throw new ChangeSetPersister.NotFoundException();
            }
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while finding the doctor");
        }
    }

    public List<Employee> findAllByStatus(String department){
        Status statusEnum = Status.valueOf(department.toUpperCase());
        return employeeRepository.findAllByStatus(statusEnum);
    }
    public List<Employee> findAllByDepartment(String department){
        Department departmentEnum = Department.valueOf(department.toUpperCase());
        return employeeRepository.findAllByDepartment(departmentEnum);
    }
}
