package com.example.demo.Repositories;

import com.example.demo.Classes.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> getPatientsByDobRange(Date start, Date end);

    @Query("SELECT p FROM Patient p WHERE p.admittingDoctor.department = :department")
    List<Patient> findByAdmittingDoctorsDepartment(@Param("department") String department);

    @Query("SELECT p FROM Patient p WHERE p.admittingDoctor.status = 'OFF'")
    List<Patient> findByDoctorStatusOff();
}
