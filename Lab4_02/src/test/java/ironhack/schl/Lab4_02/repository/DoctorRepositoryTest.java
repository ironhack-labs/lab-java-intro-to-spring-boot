package ironhack.schl.Lab4_02.repository;

import ironhack.schl.Lab4_02.model.Doctor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static ironhack.schl.Lab4_02.model.Status.ON_CALL;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DoctorRepositoryTest {
    @Autowired
    DoctorRepository doctorRepository;

    Doctor doctor;

    @BeforeEach
    void setUp() {

        doctor = new Doctor(356712, "Alonso Flores", "Cardiology", ON_CALL);
        doctorRepository.save(doctor);
        System.out.println(doctor);
    }

    @AfterEach
    void tearDown() {
        doctorRepository.deleteById(doctor.getId());
    }

    @Test
    public void findAll_doctors_doctorList() {
        List<Doctor> doctorList = doctorRepository.findAll();
        System.out.println(doctorList);
        assertEquals(6, doctorList.size());
    }

    @Test
    public void findById_validId_correctDoctor() {
        Optional<Doctor> doctorOptional = doctorRepository.findById(1);
        assertTrue(doctorOptional.isPresent());
        System.out.println(doctorOptional.get());
        assertEquals("Alonso Flores", doctorOptional.get().getDoctor());
    }

    @Test
    public void findById_invalidId_doctorNotPresent() {
        Optional<Doctor> doctorOptional = doctorRepository.findById(30392);
        assertTrue(doctorOptional.isEmpty());
    }

}