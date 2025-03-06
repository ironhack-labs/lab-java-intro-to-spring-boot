package com.ironhack.lab402.repository;

import com.ironhack.lab402.model.Patient;
import com.ironhack.lab402.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    List<Patient> findByDateOfBirthBetween(LocalDate startDate, LocalDate endDate);

    @Query(value = "SELECT p.* FROM patient p LEFT JOIN employee e ON p.admitted_by = e.employee_id WHERE e.department = :departmentParam", nativeQuery = true)
    List<Patient> findPatientsByDoctorDepartment(@Param("departmentParam") String department);

    @Query(value = "SELECT p.* FROM patient p LEFT JOIN employee e ON p.admitted_by = e.employee_id WHERE e.status = 'OFF'", nativeQuery = true)
    List<Patient> findPatientsByDoctorStatusOff();
}
