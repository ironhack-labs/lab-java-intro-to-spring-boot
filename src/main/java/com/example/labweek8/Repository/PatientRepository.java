package com.example.labweek8.Repository;

import com.example.labweek8.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    List<Patient> findByDateOfBirthBetween(LocalDate from, LocalDate to);

    List<Patient> findByDoctorDepartment(String department);

    List<Patient> findByDoctorStatus(EmployeeStatus employeeStatus);
}
