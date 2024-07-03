package ironhack.schl.Lab4_02.repository;

import ironhack.schl.Lab4_02.model.Patient;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PatientRepositoryTest {
    @Autowired
    PatientRepository patientRepository;

    Patient patient;

    @BeforeEach
    void setUp() {

            patient = new Patient(1, "Jaime Jordan");
            patientRepository.save(patient);
            System.out.println(patient);

    }

    @AfterEach
    void tearDown() {
        patientRepository.deleteById(patient.getId());
    }

    @Test
    public void findAll_patients_patientList() {
        List<Patient> patientList = patientRepository.findAll();
        System.out.println(patientList);
        assertEquals(1, patientList.size());
    }

    @Test
    public void findById_validId_correctPatient() {
        Optional<Patient> patientOptional = patientRepository.findById(1);
        assertTrue(patientOptional.isPresent());
        System.out.println(patientOptional.get());
        assertEquals("Jaime Jordan", patientOptional.get().getPatient());
    }

    @Test
    public void findById_invalidId_patientNotPresent() {
        Optional<Patient> patientOptional = patientRepository.findById(9);
        assertTrue(patientOptional.isEmpty());
    }

}