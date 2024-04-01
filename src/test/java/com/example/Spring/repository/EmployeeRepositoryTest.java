package com.example.Spring.repository;

import com.example.Spring.EmployeeStatus;
import com.example.Spring.model.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository employeeRepository;
    Employee employee1;
    Employee employee2;
    Employee employee3;

    @BeforeEach
    void setUp() {
        employee1 = new Employee("cardiology","Xavi", EmployeeStatus.ON);
        employee2 = new Employee("odontology","Thais", EmployeeStatus.ON);
        employee3 = new Employee("odontology","Haku", EmployeeStatus.OFF);
        employeeRepository.save(employee1);
        employeeRepository.save(employee2);
        employeeRepository.save(employee3);
    }

    @AfterEach
    void tearDown() {
        employeeRepository.deleteAll();
    }

    @Test
    public void createEmployee(){
        Optional<Employee> employeeFound = employeeRepository.findByEmployeeId(employee1.getEmployeeId());
        assertTrue(employeeFound.isPresent());
        assertEquals(employee1.getEmployeeId(),employeeFound.get().getEmployeeId());

    }

    @Test
    void findByStatus() {
        List<Employee> employeeFound = employeeRepository.findByStatus(Optional.of(EmployeeStatus.ON));
        assertEquals(employee1.getEmployeeId(),employeeFound.get(0).getEmployeeId());
        assertEquals(employee2.getEmployeeId(),employeeFound.get(1).getEmployeeId());
    }

    @Test
    void findAllByDepartment() {
        List<Employee> employeeFound = employeeRepository.findAllByDepartment(Optional.of("odontology"));
        assertEquals(employee2.getEmployeeId(),employeeFound.get(0).getEmployeeId());
        assertEquals(employee3.getEmployeeId(),employeeFound.get(1).getEmployeeId());
    }
}