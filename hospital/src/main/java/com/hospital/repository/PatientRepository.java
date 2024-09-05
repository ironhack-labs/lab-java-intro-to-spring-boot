package com.hospital.repository;

import com.hospital.enums.Department;
import com.hospital.enums.Status;
import com.hospital.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByDateOfBirthBetween(LocalDate startDate, LocalDate endDate);
    List<Patient> findByAdmittedByDepartment(Department department);
    List<Patient> findByAdmittedByStatus(Status status);
}
