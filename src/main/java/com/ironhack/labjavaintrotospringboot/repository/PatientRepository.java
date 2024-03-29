package com.ironhack.labjavaintrotospringboot.repository;

import com.ironhack.labjavaintrotospringboot.model.user.Department;
import com.ironhack.labjavaintrotospringboot.model.user.Doctor;
import com.ironhack.labjavaintrotospringboot.model.user.DoctorStatus;
import com.ironhack.labjavaintrotospringboot.model.user.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    List<Patient> findByDoctor(Doctor doctor);

    @Query("SELECT patient FROM Patient patient WHERE patient.doctor.department = :department")
    List<Patient> findPatientsByAdmittingDepartment(@Param("department") Department department);

    @Query("SELECT patient FROM Patient patient WHERE patient.doctor.status = OFF")
    List<Patient> findPatientsByOffDoctor();

    @Query("SELECT patient FROM Patient patient WHERE patient.dateOfBirth BETWEEN :startDate AND :endDate")
    List<Patient> findPatientsByBirthDateRange(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
