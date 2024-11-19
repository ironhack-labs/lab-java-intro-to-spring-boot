package com.Hospital.lab.service;




import com.Hospital.lab.model.Patient;
import com.Hospital.lab.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private final PatientRepository repository;

    public PatientService(PatientRepository repository) {
        this.repository = repository;
    }

    public List getAllPatients() {
        return repository.findAll();
    }

    public Patient getPatientById(Long id) {
        return (Patient) repository.findById(id).orElse(null);
    }

    public List<Patient> getPatientsByDateOfBirthRange(String startDate, String endDate) {
        return repository.findByDateOfBirthBetween(startDate, endDate);
    }

    public List<Patient> getPatientsByDoctorDepartment(String department) {
        return repository.findByAdmittedByDepartment(department);
    }

    public List<Patient> getPatientsByDoctorStatus(String status) {
        return repository.findByAdmittedByStatus(status);
    }
}

