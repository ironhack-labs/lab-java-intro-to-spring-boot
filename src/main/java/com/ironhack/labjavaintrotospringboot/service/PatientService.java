package com.ironhack.labjavaintrotospringboot.service;

import com.ironhack.labjavaintrotospringboot.model.user.Patient;
import com.ironhack.labjavaintrotospringboot.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients() { return patientRepository.findAll(); }
    public Patient addNewPatient(Patient patient) { return patientRepository.save(patient); }
}
