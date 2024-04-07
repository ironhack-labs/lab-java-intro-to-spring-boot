package com.ironhack.repository;

import com.ironhack.model.Employee;
import com.ironhack.model.Patient;
import com.ironhack.model.enums.Status;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PatientRepositoryTest {
    private Patient patient1 = new Patient();

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @BeforeEach
    void setUp() {
        List<Employee> employees = new ArrayList<>();
        Employee employee1 = new Employee(123,"cardiology", "John Smith", Status.OFF);
        employees.add(employee1);
        Employee employee2 = new Employee(456,"dermatology", "Blake Morrison", Status.ON);
        employees.add(employee2);
        Employee employee3 = new Employee(789,"oncology", "Brandon Green", Status.ON_CALL);
        employees.add(employee3);
        employeeRepository.saveAll(employees);

        List<Patient> patients = new ArrayList<>();
        Date birthDate1 = new Date(1989, 6, 11);
        patient1.setPatientId(123);
        patient1.setName("Juan Garcia");
        patient1.setDateOfBirth(birthDate1);
        patient1.setAdmittedBy(employee1);
        patients.add(patient1);
        Date birthDate2 = new Date(1995, 9, 8);
        Patient patient2 = new Patient(456, "Marc Williams", birthDate2, employee2);
        patients.add(patient2);
        Date birthDate3 = new Date(2005, 1, 29);
        Patient patient3 = new Patient(789, "Eva Rodriguez", birthDate3, employee3);
        patients.add(patient3);
        patientRepository.saveAll(patients);
    }

    @AfterEach
    void tearDown() {
        patientRepository.deleteAll();
        patientRepository.flush();
        employeeRepository.deleteAll();
        employeeRepository.flush();
    }

    @Test
    public void testFindAll() {
        List<Patient> patients = patientRepository.findAll();
        assertEquals(3, patients.size());
    }

    @Test
    public void testFindByPatientId_Positive() {
        Optional<Patient> patient = patientRepository.findByPatientId(123);
        assertTrue(patient.isPresent());
        assertEquals(patient1, patient.get());
    }

    @Test
    public void testFindByPatientId_Negative() {
        Optional<Patient> patient = patientRepository.findByPatientId(321);
        assertFalse(patient.isPresent());
    }

    @Test
    public void testFindAllByDateOfBirthBetween() {
        Date startDate = new Date(1980, 1, 1);
        Date endDate = new Date(2000, 1, 1);
        List<Patient> patients = patientRepository.findAllByDateOfBirthBetween(startDate, endDate);
        assertEquals(2, patients.size());
    }

    @Test
    public void testFindAllByAdmittedBy_Department() {
        List<Patient> patients = patientRepository.findAllByAdmittedBy_Department("cardiology");
        assertEquals(1, patients.size());
    }

    @Test
    public void testFindAllByAdmittedBy_StatusOFF() {
        List<Patient> patients = patientRepository.findAllByAdmittedBy_Status(Status.OFF);
        assertEquals(1, patients.size());
    }
}