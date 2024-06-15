package com.ironhack.labspringboot9.service;

import com.ironhack.labspringboot9.enums.Status;
import com.ironhack.labspringboot9.model.Patient;
import com.ironhack.labspringboot9.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
    public Patient getPatientById(Long id) {
        return  patientRepository.getReferenceById(id);

    }
    public List<Patient> getPatientByDateOfBirthRange(Date from, Date to) {
        return patientRepository.findByDateOfBirthBetween(from,to);
    }
    public List<Patient>getPatientByDoctorsDepartment(String department){
        return patientRepository.findByDoctorsDepartment(department);
    }
    public List<Patient>getPatientByDoctorStatus(Status status){
        return patientRepository.findByDoctorsStatus(status);
    }

    }
