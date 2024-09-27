package com.springBoot.repository;

import com.springBoot.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    List<Patient> findByDateOfBirthBetween(LocalDate start, LocalDate end);

    @Query("SELECT p FROM Patient p JOIN p.employeeId e WHERE e.employeeId = :employeeId AND e.department = :department")
    List<Patient> admittedBy(@Param("employeeId") Integer employeeId, @Param("department") String department);

    @Query("SELECT p FROM Patient p JOIN p.employeeId e WHERE e.status = 2")
    List<Patient> withOffDoctor();
}
