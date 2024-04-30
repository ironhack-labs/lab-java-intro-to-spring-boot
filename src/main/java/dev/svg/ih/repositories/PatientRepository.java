package dev.svg.ih.repositories;

import dev.svg.ih.model.Doctor;
import dev.svg.ih.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    List<Patient> findByDateOfBirth(String dateOfBirth);

    List<Patient> findPatientsByDoctor(Doctor doctor);

    List<Patient> findByDateOfBirthAndDoctor(String dateOfBirth, Doctor doctor);

}
