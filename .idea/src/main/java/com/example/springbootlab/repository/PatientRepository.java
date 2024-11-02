package com.example.springbootlab.repository;

import com.example.springbootlab.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByDateOfBirthBetween(LocalDate startDate, LocalDate endDate);

    @Query("SELECT p FROM Patient p WHERE p.admittedBy.department = :department")
    List<Patient> findByAdmittingDoctorDepartment(String department);

    @Query("SELECT p FROM Patient p WHERE p.admittedBy.status = 'OFF'")
    List<Patient> findByDoctorStatusOff();
}