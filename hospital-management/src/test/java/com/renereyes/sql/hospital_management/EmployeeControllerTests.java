// src/test/java/com/renereyes/sql/hospitalmanagement/EmployeeControllerTests.java
package com.renereyes.sql.hospitalmanagement;

import com.renereyes.sql.hospitalmanagement.entity.Employee;
import com.renereyes.sql.hospitalmanagement.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class EmployeeControllerTests {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testFindAllDoctors() {
        List<Employee> employees = employeeRepository.findAll();
        assertThat(employees).isNotEmpty();
    }

    @Test
    public void testFindDoctorById() {
        Employee employee = employeeRepository.findById(356712L).orElse(null);
        assertThat(employee).isNotNull();
    }
}
