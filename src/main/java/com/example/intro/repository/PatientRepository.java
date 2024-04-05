package com.example.intro.repository;

import com.example.intro.model.Patient;
import com.example.intro.model.utils.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    Optional<Patient> findPatientById(int id);
    @Query("SELECT u FROM Patient u WHERE u.date_of_birth BETWEEN :startDate AND :endDate")
    List<Patient> findPatientsWithDateOfBirthBetween(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query("SELECT u FROM Patient u WHERE u.admitted_by.department = :doctorDepartment")
    List<Patient> findPatientsByEmployeeDepartment(@Param("doctorDepartment")String doctorDepartment);

    @Query("SELECT u FROM Patient u WHERE u.admitted_by.status = :status")
    List<Patient> findPatientsByEmployeeStatus(@Param("status") Status status);
}
