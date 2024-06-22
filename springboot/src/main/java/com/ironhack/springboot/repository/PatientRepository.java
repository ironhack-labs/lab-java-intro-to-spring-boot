package com.ironhack.springboot.repository;

import com.ironhack.springboot.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

//    Get all patients: Create a route to get all patients.
//    Get patient by ID: Create a route to get a patient by patient_id.
//    Get patients by date of birth range: Create a route to get patients date of birth within a specified range.
//    Get patients by admitting doctor's department: Create a route to get patients by the department that their admitting doctor is in (For example, get all patients admitted by a doctor in cardiology).
//    Get all patients with a doctor whose status is OFF: Create a route to get all patients with a doctor whose status is OFF.

    List<Patient> getAllPatients();
    List<Patient> getPatientsByDateOfBirthRange(String dateOfBirthStart, String dateOfBirthEnd);
    List<Patient> getPatientsByAdmittingDoctorDepartment(String department);
    List<Patient> getPatientsWithDoctorOff();

}
