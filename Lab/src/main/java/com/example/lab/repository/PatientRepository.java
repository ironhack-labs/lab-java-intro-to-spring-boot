package com.example.lab.repository;

import com.example.lab.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {

    Optional<List<Patient>> findByDateOfBirthBetween(LocalDate dateOfBirth, LocalDate dateOfBirth2);
    Optional<List<Patient>> findByAdmittedByDepartment(String department);
    Optional<List<Patient>> findByAdmittedByStatus(String status);
}