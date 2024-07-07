package com.example.lab_java_intro_to_spring_boot.repository;

import com.example.lab_java_intro_to_spring_boot.model.Employee;
import com.example.lab_java_intro_to_spring_boot.model.Patient;
import com.example.lab_java_intro_to_spring_boot.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, String> {
    Optional<Patient> findById(Integer id);
    List<Patient> findAllByDateOfBirth(LocalDate dateOfBirth);
    List<Patient> findAllByName(String name);
    List<Patient> findAllByAdmittedBy(Employee admittedBy);
    //List<Patient> findAllByStatus(Status status);

   // List<Patient> findAllPatientByStatusParms(String name, Status status);
}
