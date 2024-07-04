package com.example.get.repository;

import com.example.get.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    List<Patient> findByAdmittingEmployee_Department(String department);

    List<Patient> findByDateOfBirthBetween(LocalDate start, LocalDate end);

    List<Patient> findByAdmittingEmployee_Status(String off);
}
