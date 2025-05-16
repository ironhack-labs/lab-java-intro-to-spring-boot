package com.ironhack.Lab402IntroToSpringBoot202302.service.interfaces;

import com.ironhack.Lab402IntroToSpringBoot202302.model.EmployeeStatus;
import com.ironhack.Lab402IntroToSpringBoot202302.model.Patient;

import java.util.Date;
import java.util.List;

public interface IPatientService {
    Patient savePatient(Patient patient);


    List<Patient> getAllPatient();

    Patient getPatientById(Long id);


    List<Patient> findPatientsByDateOfBirthRange(Date start, Date end);


    List<Patient> findByEmployeeId_Department(String department);


    List<Patient> findByEmployeeId_Status(EmployeeStatus status);
}
