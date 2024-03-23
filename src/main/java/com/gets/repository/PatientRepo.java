package com.gets.repository;

import com.gets.Enums.Status;
import com.gets.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepo  extends JpaRepository<Patient, Integer> {

    Optional<Patient> findById(int id);

    @Query("SELECT p FROM Patient p WHERE p.dateOfBirth BETWEEN :startDate AND :endDate")
    List<Patient> findPatientsByDateOfBirthRange(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query("SELECT p FROM Patient p JOIN p.admittedBy d WHERE d.department = :department")
    List<Patient> findPatientsByEmployeeDepartment(@Param("department") String department);

    @Query("SELECT p FROM Patient p JOIN p.admittedBy d WHERE d.status = :status")
    List<Patient> findPatientsByEmployeeStatus(@Param("status") Status status);
}

