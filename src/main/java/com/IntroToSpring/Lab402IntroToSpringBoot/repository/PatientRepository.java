package com.IntroToSpring.Lab402IntroToSpringBoot.repository;

import com.IntroToSpring.Lab402IntroToSpringBoot.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long>{
    List<Patient> findByDateOfBirthBetween(LocalDate startDate, LocalDate endDate);
    List<Patient> findByAdmittedBy_Department(String department);
    List<Patient> findByAdmittedBy_Status(String status);
}
