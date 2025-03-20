package com.ironhack.lab401.repository;

import com.ironhack.lab401.model.Employee;
import com.ironhack.lab401.model.EmployeeStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeRepositoryTest {
    @Autowired
    EmployeeRepository employeeRepository;



    @Test
    public void myTest(){
        Employee myEmployee = new Employee(234, "cardiology", "David", EmployeeStatus.ON, new ArrayList<>());
        employeeRepository.save(myEmployee);

        List<Employee> myEmployees = employeeRepository.findAll();
        assertEquals(1, myEmployees.size());
    }

}