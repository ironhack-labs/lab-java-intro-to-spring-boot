package com.example.Lab402.repositories;

import com.example.Lab402.enums.EmployeeStatus;
import com.example.Lab402.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    List<Patient> findByBirthDate(Date date1, Date date2);
    List<Patient> findByDepartmentAdmittedTo(String department);
    List<Patient> findByOffDoctor(EmployeeStatus status);
}