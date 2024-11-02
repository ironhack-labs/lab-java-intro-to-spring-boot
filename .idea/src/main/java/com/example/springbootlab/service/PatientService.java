package com.example.springbootlab.service;

import com.example.springbootlab.model.Patient;
import com.example.springbootlab.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Optional<Patient> getPatientById(Long id) {
        return patientRepository.findById(id);
    }

    public List<Patient> getPatientsByDateOfBirthRange(LocalDate startDate, LocalDate endDate) {
        return patientRepository.findByDateOfBirthBetween(startDate, endDate);
    }

    public List<Patient> getPatientsByAdmittingDoctorDepartment(String department) {
        return patientRepository.findByAdmittingDoctorDepartment(department);
    }

    public List<Patient> getPatientsWithDoctorStatusOff() {
        return patientRepository.findByDoctorStatusOff();
    }
}