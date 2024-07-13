package com.ironhack.week9_lab.repository;


import com.ironhack.week9_lab.model.EmployeeStatus;
import com.ironhack.week9_lab.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository

public interface PatientRepository  extends JpaRepository<Patient, Integer> {

    //List<patient> findAllPatients();

    //Get patient date of birth range;
    //Create a route to get patients date of birth within a specified range.
    List<Patient> findByDateOfBirthBetween(LocalDate dateOfBirth, LocalDate dateOfBirth2);

    //Get Patient by admitting doctor`s department;
    //Create a rout to get patient by the department that their admitting doctor is in
    //(For example, get all patients admitted by a doctor in cardiology).
    List<Patient> findByAdmittedBy_Department(String admittedByDepartment);

    // Get all patients with a doctor whose status is OFF:
    //Create a route to get all patients with a doctor whose status is OFF.
    List<Patient> findByAdmittedBy_Status(EmployeeStatus status);




}
