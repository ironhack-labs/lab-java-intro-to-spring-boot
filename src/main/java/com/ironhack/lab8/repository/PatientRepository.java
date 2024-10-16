package com.ironhack.lab8.repository;

import com.ironhack.lab8.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    List<Patient> findByDateOfBirth(LocalDate dateOfBirth);
    List<Patient> findByAdmittedBy(int admittedBy);
    List<Patient> findByAdmittedByIn(List<Long> admittedBy);

}
