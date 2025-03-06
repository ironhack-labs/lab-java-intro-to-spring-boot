package com.ironhack.lab402.service.impl;

import com.ironhack.lab402.model.Patient;
import com.ironhack.lab402.repository.PatientRepository;
import com.ironhack.lab402.service.interfaces.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService implements IPatientService {
    @Autowired
    PatientRepository patientRepository;

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(Integer patientID) {
        Optional<Patient> patientOptional = patientRepository.findById(patientID);
        return patientOptional.get();
    }

    @Override
    public List<Patient> getPatientsByDateOfBirthRange(LocalDate startDate, LocalDate endDate) {
        return patientRepository.findByDateOfBirthBetween(startDate, endDate);
    }

    @Override
    public List<Patient> getPatientsByDoctorDepartment(String department) {
        return patientRepository.findPatientsByDoctorDepartment(department);
    }

    @Override
    public List<Patient> getPatientsByDoctorStatusOff() {
        return patientRepository.findPatientsByDoctorStatusOff();
    }
}
