package com.ironhack.repository;

import com.ironhack.model.Employee;
import com.ironhack.model.Patient;
import com.ironhack.model.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    List<Patient> findAll();
    Optional<Patient> findByPatientId(int patientId);
    List<Patient> findAllByDateOfBirthBetween(Date startDate, Date endDate);
    List<Patient> findAllByAdmittedBy_Department(String department);
    List<Patient> findAllByAdmittedBy_Status(Status status);
}
