package com.ironhack.Lab402IntroToSpringBoot202302.service.impl;

import com.ironhack.Lab402IntroToSpringBoot202302.model.EmployeeStatus;
import com.ironhack.Lab402IntroToSpringBoot202302.model.Patient;
import com.ironhack.Lab402IntroToSpringBoot202302.reporitory.PatientRepository;
import com.ironhack.Lab402IntroToSpringBoot202302.service.interfaces.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService implements IPatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> getAllPatient() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(Long id) {
        Optional<Patient> patientOptional = patientRepository.findById(id);
        if(patientOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient " + id + " not found");
        return patientOptional.get();
    }

    @Override
    public List<Patient> findPatientsByDateOfBirthRange(Date start, Date end) {
        return patientRepository.findByPatientDateOfBirthBetween(start, end);
    }

    @Override
    public List<Patient> findByEmployeeId_Department(String department) {
        return patientRepository.findByEmployeeId_Department(department);
    }

    @Override
    public List<Patient> findByEmployeeId_Status(EmployeeStatus status) {
        return patientRepository.findByEmployeeId_Status(status);
    }
}


