package com.ironhack.repository;

import com.ironhack.model.Employee;
import com.ironhack.model.enums.Status;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeRepositoryTest {
    private Employee employee1 = new Employee();

    @Autowired
    private EmployeeRepository employeeRepository;

    @BeforeEach
    void setUp() {
        List<Employee> employees = new ArrayList<>();
        employee1.setEmployeeId(123);
        employee1.setDepartment("cardiology");
        employee1.setName("John Smith");
        employee1.setStatus(Status.OFF);
        employees.add(employee1);
        Employee employee2 = new Employee(456, "psychology", "Maria Pearson", Status.OFF);
        employees.add(employee2);
        Employee employee3 = new Employee(789, "oncology", "Jessica Green", Status.ON);
        employees.add(employee3);
        employeeRepository.saveAll(employees);
    }

    @AfterEach
    void tearDown() {
        employeeRepository.deleteAll();
        employeeRepository.flush();
    }

    @Test
    public void testFindAll() {
        List<Employee> employees = employeeRepository.findAll();
        assertEquals(3, employees.size());
    }

    @Test
    public void testFindByEmployeeId_Positive() {
        Optional<Employee> employee = employeeRepository.findByEmployeeId(123);
        assertTrue(employee.isPresent());
        assertEquals(employee1, employee.get());
    }

    @Test
    public void testFindByEmployeeId_Negative() {
        Optional<Employee> employee = employeeRepository.findByEmployeeId(321);
        assertFalse(employee.isPresent());
    }

    @Test
    public void testFindAllByStatus_Positive() {
        List<Employee> employees = employeeRepository.findAllByStatus(Status.OFF);
        assertEquals(2, employees.size());
    }

    @Test
    public void testFindAllByStatus_Negative() {
        List<Employee> employees = employeeRepository.findAllByStatus(Status.ON_CALL);
        assertEquals(0, employees.size());
    }

    @Test
    public void testFindAllByDepartment_Positive() {
        List<Employee> employees = employeeRepository.findAllByDepartment("cardiology");
        assertEquals(1, employees.size());
    }

    @Test
    public void testFindAllByDepartment_Negative() {
        List<Employee> employees = employeeRepository.findAllByDepartment("dermatology");
        assertEquals(0, employees.size());
    }
}