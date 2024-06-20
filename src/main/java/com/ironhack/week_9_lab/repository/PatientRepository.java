package com.ironhack.week_9_lab.repository;

import com.ironhack.week_9_lab.model.EmployeeStatus;
import com.ironhack.week_9_lab.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    //List<Patient> findAllPatients();

    // Get patients by date of birth range:
    // Create a route to get patients date of birth within a specified range.
    List<Patient> findByDateOfBirthBetween(LocalDate dateOfBirth, LocalDate dateOfBirth2);

    //Get patients by admitting doctor's department:
    // Create a route to get patients by the department that their admitting doctor is in
    // (For example, get all patients admitted by a doctor in cardiology).
    List<Patient> fidByAdmittedBy_Department(String admittedByDepartment);

    //Get all patients with a doctor whose status is OFF:
    // Create a route to get all patients with a doctor whose status is OFF.
    List<Patient> findByAdmittedBy_Status(EmployeeStatus status);
}
