package com.ironhack.labweek8.repository;

import com.ironhack.labweek8.model.EmployeeStatus;
import com.ironhack.labweek8.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    List<Patient> findByDateOfBirthBetween(LocalDate from, LocalDate to);

    @Query(value = "SELECT p FROM Patient p WHERE p.doctor.department IN :department")
    List<Patient> findByDoctorDepartment(@Param("department") String department);

    @Query(value = "SELECT p FROM Patient p WHERE p.doctor.status IN :status")
    List<Patient> findByDoctorStatus(@Param("status") EmployeeStatus employeeStatus);
}
