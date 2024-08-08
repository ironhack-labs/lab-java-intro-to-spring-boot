package com.ironhack.week_9_lab.repository;


import com.ironhack.week_9_lab.model.Employee;
import com.ironhack.week_9_lab.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByDateOfBirthBetween(String startDate, String endDate);
    List<Patient> findByAdmittedByDepartment(String department);
    List<Patient> findByAdmittedByStatus(String status);
}
