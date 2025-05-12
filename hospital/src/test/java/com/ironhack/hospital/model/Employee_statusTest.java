package com.ironhack.hospital.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.ironhack.hospital.model.Employee.Status;
import org.springframework.boot.test.context.SpringBootTest;
import com.ironhack.hospital.repository.EmployeeRepository;

@Order(0)
@SpringBootTest
public class Employee_statusTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testCreateUsers() {

        Employee employee = new Employee();
        employee.setEmployee_id(356712);
        employee.setDepartment("cardiology");
        employee.setName("Alonso Flores");
        employee.setStatus(Status.ON_CALL);
        employeeRepository.save(employee);

        employee.setEmployee_id(564134);
        employee.setDepartment("immunology");
        employee.setName("Sam Ortega");
        employee.setStatus(Status.ON);

        employeeRepository.save(employee);

        employee.setEmployee_id(761527);
        employee.setDepartment("cardiology");
        employee.setName("German Ruiz");
        employee.setStatus(Status.OFF);

        employeeRepository.save(employee);

        employee.setEmployee_id(166552);
        employee.setDepartment("pulmonary");
        employee.setName("Maria Lin");
        employee.setStatus(Status.ON);

        employeeRepository.save(employee);

        employee.setEmployee_id(156545);
        employee.setDepartment("orthopaedic");
        employee.setName("Paolo Rodrigues");
        employee.setStatus(Status.ON_CALL);

        employeeRepository.save(employee);

        employee.setEmployee_id(172456);
        employee.setDepartment("psychiatric");
        employee.setName("John Paul Armes");
        employee.setStatus(Status.OFF);

        employeeRepository.save(employee);

        assertEquals(employee, employee);
    }

}