// src/test/java/com/renereyes/sql/hospitalmanagement/PatientControllerTests.java
package com.renereyes.sql.hospitalmanagement;

import com.renereyes.sql.hospitalmanagement.entity.Patient;
import com.renereyes.sql.hospitalmanagement.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PatientControllerTests {
    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void testFindAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        assertThat(patients).isNotEmpty();
    }

    @Test
    public void testFindPatientById() {
        Patient patient = patientRepository.findById(1L).orElse(null);
        assertThat(patient).isNotNull();
    }
}
