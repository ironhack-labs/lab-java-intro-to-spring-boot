package com.ironhack.multicityhospital2.repository;

import com.ironhack.multicityhospital2.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Optional<Patient> findByAdmittedBy(Long admittedBy);
}
