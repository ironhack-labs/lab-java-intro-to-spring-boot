package com.ironhack.labspringboot9.repository;

import com.ironhack.labspringboot9.enums.Status;
import com.ironhack.labspringboot9.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByDateOfBirthBetween(Date from, Date to);
    @Query("SELECT p FROM Patient p JOIN p.admitted_by e WHERE e.department = :departmentName")
    List<Patient> findByDoctorsDepartment(@Param("departmentName") String departmentName);
    @Query("SELECT p FROM Patient p JOIN p.admitted_by e WHERE e.status = :doctorStatus")
    List<Patient> findByDoctorsStatus(@Param("doctorStatus") Status doctorStatus);
}
