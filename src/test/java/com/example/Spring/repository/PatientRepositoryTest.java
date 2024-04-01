package com.example.Spring.repository;

import com.example.Spring.EmployeeStatus;
import com.example.Spring.model.Employee;
import com.example.Spring.model.Patient;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PatientRepositoryTest {
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    Patient patient1;
    Patient patient2;
    Patient patient3;
    Patient patient4;
    Patient patient5;

    @BeforeEach
    void setUp() {
        Date date1 = new Date(1990,1,23);
        Date date2 = new Date(1991,3,03);
        Date date3 = new Date(1986,7,10);
        Date date4 = new Date(1995,2,20);
        Date date5 = new Date(1999,5,30);
        Employee employee1 = new Employee("cardiology","Xavi", EmployeeStatus.ON);
        Employee employee2 = new Employee("odontology","Thais", EmployeeStatus.ON);
        Employee employee3 = new Employee("odontology","Haku", EmployeeStatus.OFF);
        employeeRepository.save(employee1);
        employeeRepository.save(employee2);
        employeeRepository.save(employee3);
        patient1 = new Patient("Ricard",date1 ,employee1);
        patientRepository.save(patient1);
        patient2 = new Patient("Victor",date2 ,employee1);
        patientRepository.save(patient2);
        patient3 = new Patient("Monica",date3 ,employee1);
        patientRepository.save(patient3);
        patient4 = new Patient("Laura",date4 ,employee2);
        patientRepository.save(patient4);
        patient5 = new Patient("Amanda",date5 ,employee3);
        patientRepository.save(patient5);
    }

    @AfterEach
    void tearDown() {
        patientRepository.deleteAll();
    }

    @Test
    public void createPatient(){
        Optional<Patient> patientFound = patientRepository.findByPatientId(patient1.getPatientId());
        assertTrue(patientFound.isPresent());
        assertEquals(patient1.getPatientId(),patientFound.get().getPatientId());
    }

    @Test
    void findByDateOfBirthBetween() {
        List<Patient> patientFound = patientRepository.findByDateOfBirthBetween(new Date(1990,1,23),new Date(1995,2,20));
        assertEquals(patient1.getPatientId(),patientFound.get(0).getPatientId());
        assertEquals(patient2.getPatientId(),patientFound.get(1).getPatientId());
        assertEquals(patient4.getPatientId(),patientFound.get(2).getPatientId());
    }

    @Test
    void findByDoctorDepartment() {
        List<Patient> patientFound = patientRepository.findByDoctorDepartment(Optional.of("odontology"));
        assertEquals(patient4.getPatientId(),patientFound.get(0).getPatientId());
        assertEquals(patient5.getPatientId(),patientFound.get(1).getPatientId());
    }

    @Test
    void findByDoctorStatus() {
        List<Patient> patientFound = patientRepository.findByDoctorStatus(Optional.of(EmployeeStatus.ON));
        assertEquals(patient1.getPatientId(),patientFound.get(0).getPatientId());
        assertEquals(patient2.getPatientId(),patientFound.get(1).getPatientId());
        assertEquals(patient3.getPatientId(),patientFound.get(2).getPatientId());
        assertEquals(patient4.getPatientId(),patientFound.get(3).getPatientId());
    }
}