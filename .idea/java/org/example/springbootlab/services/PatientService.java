package org.example.springbootlab.services;

import org.example.springbootlab.model.Patient;
import org.example.springbootlab.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    public List<Patient> getPatientsByDateOfBirthRange(String startDate, String endDate) {
        return patientRepository.findByDateOfBirthBetween(startDate, endDate);
    }

    public List<Patient> getPatientsByDoctorDepartment(String department) {
        return patientRepository.findByAdmittedBy_Department(department);
    }

    public List<Patient> getPatientsByDoctorStatusOff() {
        return patientRepository.findByAdmittedBy_Status("OFF");
    }
}