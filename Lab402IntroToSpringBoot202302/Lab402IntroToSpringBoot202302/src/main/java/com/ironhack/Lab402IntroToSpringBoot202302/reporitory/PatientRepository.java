package com.ironhack.Lab402IntroToSpringBoot202302.reporitory;

import com.ironhack.Lab402IntroToSpringBoot202302.model.EmployeeStatus;
import com.ironhack.Lab402IntroToSpringBoot202302.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByPatientDateOfBirthBetween(Date start, Date end);

    List<Patient> findByEmployeeId_Department(String department);
    List<Patient> findByEmployeeId_Status(EmployeeStatus status);;

    // here custom methods if I need them

}
