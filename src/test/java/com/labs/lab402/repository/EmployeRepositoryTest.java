package com.labs.lab402.repository;

import com.labs.lab402.model.Employee;
import com.labs.lab402.model.Patient;
import com.labs.lab402.model.STATUS;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeRepositoryTest {

    @Autowired
    EmployeeRepository employeRepository;

    @Autowired
    PatientRepository patientRepository;

    Employee testSubject;
    Patient testSubject2;

    @BeforeEach
    void setUp(){
        testSubject = new Employee();
        testSubject.setEmployee_id(57123);
        testSubject.setName("Johny");
        testSubject.setDepartment("oncology");
        testSubject.setStatus(STATUS.OFF);
        employeRepository.save(testSubject);

        testSubject2 = new Patient();
        testSubject2.setName("Angelina");
        testSubject2.setDateOfBirth(LocalDate.of(2025, 5, 5));
        patientRepository.save(testSubject2);//ccheckingg
    }

    @AfterEach
    void tearDown(){
        patientRepository.deleteAll();
        employeRepository.deleteAll();
    }

    @Test
    public void testEmployeeCreatedCorrectly(){
        assertEquals(1,employeRepository.findAll().size());
    }

    @Test
    public void testPatientCreatedCorrectly(){
        assertEquals(1,patientRepository.findAll().size());
    }

    @Test
    public void assignPatientToEmployee_validRelation(){
        Patient patient = patientRepository.findAll().get(0);
        Employee employee = employeRepository.findAll().get(0);
        patient.setEmployee(employee);
        List<Patient> patientList= employee.getPatientList();
        patientList.add(patient);
        employee.setPatientList(patientList);
        patientRepository.save(patient);
        employeRepository.save(employee);

        assertEquals("Angelina",employeRepository.findAll().get(0).getPatientList().get(0).getName());
        assertEquals("Johny",patientRepository.findAll().get(0).getEmployee().getName());

    }

}