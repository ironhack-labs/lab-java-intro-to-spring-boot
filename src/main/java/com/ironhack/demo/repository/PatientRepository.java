package com.ironhack.demo.repository;

import com.ironhack.demo.enums.Department;
import com.ironhack.demo.enums.Status;
import com.ironhack.demo.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    @Query("SELECT p FROM Patient p WHERE p.dateOfBirth BETWEEN :startDate AND :endDate")
    List<Patient> findPatientsByDateOfBirthRange(LocalDate startDate, LocalDate endDate);
    @Query("SELECT p FROM Patient p WHERE p.admittedBy.department = :department")
    List<Patient> findPatientsByAdmittingDoctorDepartment(Department department);
    @Query("SELECT p FROM Patient p WHERE p.admittedBy.status = :OFF")
    List<Patient> findAllPatientsWithDoctorStatusOff();
}
