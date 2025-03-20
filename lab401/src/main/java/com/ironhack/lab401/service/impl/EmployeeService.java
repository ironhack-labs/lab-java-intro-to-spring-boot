package com.ironhack.lab401.service.impl;

import com.ironhack.lab401.model.Employee;
import com.ironhack.lab401.model.EmployeeStatus;
import com.ironhack.lab401.repository.EmployeeRepository;
import com.ironhack.lab401.service.interfaces.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllDoctor() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getDoctorById(Integer employee_id) {
        Optional <Employee> employee = employeeRepository.findById(employee_id);
        if(employee.isEmpty()) return null;
        return employee.get();
    }

    @Override
    public List<Employee> getDoctorByStatus(EmployeeStatus employeeStatus) {
        return employeeRepository.findByEmployeeStatus(employeeStatus);
    }

    @Override
    public List<Employee> getDoctorByDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }

//    @Override
//    public void saveDoctor(Employee doctor){
//        employeeRepository.save(doctor);
//    }
}
