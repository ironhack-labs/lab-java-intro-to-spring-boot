package com.ironhack.lab402.repository;

import com.ironhack.lab402.model.Employee;
import com.ironhack.lab402.model.Status;
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

    @Test
    void findAll_doctors_employeeList(){
        List<Employee> doctors = employeeRepository.findAll();

        System.out.println(doctors);

        assertEquals(6, doctors.size());
    }

    @Test
    void findDoctor_employeeId_correctDoctor(){
        Optional<Employee> doctor = employeeRepository.findById(564134);
        assertTrue(doctor.isPresent());

        System.out.println(doctor);
        assertEquals("Sam Ortega", doctor.get().getName());
    }

    @Test
    void findDoctors_status_employeeList() {
        List<Employee> doctorStatus = employeeRepository.findAllByStatus(Status.ON);

        System.out.println(doctorStatus);

        assertEquals(2, doctorStatus.size());
    }

    @Test
    void findDoctors_department_employeeList(){
        List<Employee> doctorDepartment = employeeRepository.findAllByDepartment("cardiology");

        System.out.println(doctorDepartment);

        assertEquals(2, doctorDepartment.size());
    }



}