package com.ironhack.hospital.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ironhack.hospital.model.Employee.Status;
import com.ironhack.hospital.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    List<Patient> findByDateOfBirthBetween(Date start_date, Date end_date);

    List<Patient> findByAdmittedByDepartment(String department);

    List<Patient> findByAdmittedByStatus(Status status);

}
