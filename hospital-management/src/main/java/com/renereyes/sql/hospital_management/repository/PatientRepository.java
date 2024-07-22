// src/main/java/com/renereyes/sql/hospitalmanagement/repository/PatientRepository.java
package com.renereyes.sql.hospitalmanagement.repository;

import com.renereyes.sql.hospitalmanagement.entity.Patient;
import com.renereyes.sql.hospitalmanagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByDateOfBirthBetween(LocalDate startDate, LocalDate endDate);
    List<Patient> findByAdmittedBy(Employee admittedBy);
}
