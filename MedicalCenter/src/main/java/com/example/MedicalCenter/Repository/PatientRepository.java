package com.example.MedicalCenter.Repository;

import com.example.MedicalCenter.Model.EmployeeStatus;
import com.example.MedicalCenter.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByDateOfBirthBetween(LocalDate startDate, LocalDate endDate);

    List<Patient> findByAdmittedById(Long doctorId);

    List<Patient> findByAdmittedByDepartment(String department);

    List<Patient> findByAdmittedByStatus(EmployeeStatus status);


}
