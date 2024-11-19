package com.Hospital.lab.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository<Patient> extends JpaRepository<Patient, Long> {
    List<Patient> findByDateOfBirthBetween(String startDate, String endDate);
    List<Patient> findByAdmittedByDepartment(String department);
    List<Patient> findByAdmittedByStatus(String status);
}
