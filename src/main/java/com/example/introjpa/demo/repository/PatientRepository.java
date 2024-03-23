package com.example.introjpa.demo.repository;

import com.example.introjpa.demo.model.Employee;
import com.example.introjpa.demo.model.Patient;
import com.example.introjpa.demo.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, String>{
    List<Patient> findAll();

    @Query("SELECT p FROM Patient p WHERE p.admittedBy.employeeId= :employeeId")
    List<Patient> findAllByAdmittedBy(@Param("employeeId") Integer admittedBy);

    @Query("SELECT p FROM Patient p WHERE p.admittedBy.status = ?1")
    List<Patient> findAllByEmployeeStatusOff(Status status);
}
