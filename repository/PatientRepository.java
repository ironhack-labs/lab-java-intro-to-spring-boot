package com.ironhack.week9lab.repository;

import com.ironhack.week9lab.model.EmployeeStatus;
import com.ironhack.week9lab.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Integer> {
    List<Patient> findByDateOfBirthBetween(LocalDate dateOfBirth, LocalDate dateOfBirth2);

    List<Patient> findByAdmittedBy_Department(String admittedByDepartment);

    List<Patient> findByAdmittedBy_Status(EmployeeStatus status);
}
