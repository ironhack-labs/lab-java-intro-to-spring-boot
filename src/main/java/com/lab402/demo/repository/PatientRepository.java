package com.lab402.demo.repository;

import com.lab402.demo.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

    @Query("SELECT p FROM Patient p WHERE p.dateOfBirth BETWEEN ?1 AND ?2")
    List<Patient> findByDateOfBirthWithinRange(LocalDate startDate, LocalDate endDate);

    @Query(value="SELECT patient.patient_id, patient.name, patient.date_of_birth, patient.admitted_by FROM patient JOIN employee ON patient.admitted_by = employee.employee_id WHERE employee.department=?1 ", nativeQuery = true)
    List<Patient> findPatientsByDoctorDepartment(String department);

    @Query(value="SELECT patient.patient_id, patient.name, patient.date_of_birth, patient.admitted_by FROM patient JOIN employee ON patient.admitted_by = employee.employee_id WHERE employee.status='OFF'", nativeQuery=true)
    List<Patient> findPatientsWithDoctorStatusOff();

}
