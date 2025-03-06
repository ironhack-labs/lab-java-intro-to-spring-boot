package com.ironhack.lab402.repository;

import com.ironhack.lab402.model.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PatientRepositoryTest {

    @Autowired
    PatientRepository patientRepository;

    @Test
    void findAll_patients_patientList(){
        List<Patient> patientList = patientRepository.findAll();
        System.out.println(patientList);
        assertEquals(5, patientList.size());
    }

    @Test
    void findById_patientId_correctPatient(){
        Optional<Patient> optionalPatient = patientRepository.findById(5);
        assertTrue(optionalPatient.isPresent());

        System.out.println(optionalPatient.get());
        assertEquals("Marian Garcia", optionalPatient.get().getName());
    }

    @Test
    void findByDateOfBirth_startDateAndEndDate_patientList() {
        List<Patient> patientList = patientRepository.findByDateOfBirthBetween(LocalDate.of(1972,1, 12), LocalDate.of(1999,2, 15));
        System.out.println(patientList);
        assertEquals(3, patientList.size());
    }

    @Test
    void findPatientsByDoctorDepartment_department_patientList(){
        List<Patient> patientList = patientRepository.findPatientsByDoctorDepartment("cardiology");

        assertEquals(2, patientList.size());
    }

    @Test
    void findPatientsByDoctorStatus_statusOff_patientList(){
        List<Patient> patientList = patientRepository.findPatientsByDoctorStatusOff();

        assertEquals(2, patientList.size());
    }
}