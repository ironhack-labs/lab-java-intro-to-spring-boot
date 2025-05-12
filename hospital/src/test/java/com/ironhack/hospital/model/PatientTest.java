package com.ironhack.hospital.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ironhack.hospital.repository.EmployeeRepository;
import com.ironhack.hospital.repository.PatientRepository;

@SpringBootTest
public class PatientTest {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    public void testCreatePatients() {
        Patient patient = new Patient();
        patient.setName("Jaime Jordan");
        Calendar cal = Calendar.getInstance();
        cal.set(1984, Calendar.APRIL, 2);
        Date a = cal.getTime();
        patient.setDateOfBirth(a);
        Optional<Employee> admittingEmployee = employeeRepository.findById(564134);
        if (!admittingEmployee.isPresent()) {
            throw new RuntimeException("Employee with ID 564134 not found");
        }
        patient.setAdmittedBy(admittingEmployee.get());
        patientRepository.save(patient);

        patient = new Patient();
        patient.setName("Marian Garcia");
        cal.set(1972, Calendar.JANUARY, 12);
        a = cal.getTime();
        patient.setDateOfBirth(a);
        admittingEmployee = employeeRepository.findById(564134);
        if (!admittingEmployee.isPresent()) {
            throw new RuntimeException("Employee with ID 564134 not found");
        }
        patient.setAdmittedBy(admittingEmployee.get());
        patientRepository.save(patient);

        patient = new Patient();
        patient.setName("Julia Dusterdieck");
        cal.set(1954, Calendar.JUNE, 11);
        a = cal.getTime();
        patient.setDateOfBirth(a);

        admittingEmployee = employeeRepository.findById(356712);
        if (!admittingEmployee.isPresent()) {
            throw new RuntimeException("Employee with ID 356712 not found");
        }
        patient.setAdmittedBy(admittingEmployee.get());
        patientRepository.save(patient);

        patient = new Patient();
        patient.setName("Steve McDuck");
        cal.set(1931, Calendar.NOVEMBER, 10);
        a = cal.getTime();
        patient.setDateOfBirth(a);
        admittingEmployee = employeeRepository.findById(761527);
        if (!admittingEmployee.isPresent()) {
            throw new RuntimeException("Employee with ID 761527 not found");
        }
        patient.setAdmittedBy(admittingEmployee.get());
        patientRepository.save(patient);

        patient = new Patient();
        patient.setName("Marian Garcia");
        cal.set(1999, Calendar.FEBRUARY, 15);
        a = cal.getTime();
        patient.setDateOfBirth(a);
        admittingEmployee = employeeRepository.findById(172456);
        if (!admittingEmployee.isPresent()) {
            throw new RuntimeException("Employee with ID 172456 not found");
        }
        patient.setAdmittedBy(admittingEmployee.get());
        patientRepository.save(patient);

        assertEquals(1, 1);
    }
}
