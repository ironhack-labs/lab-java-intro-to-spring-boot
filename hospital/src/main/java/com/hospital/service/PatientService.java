package com.hospital.service;

import com.hospital.enums.Department;
import com.hospital.enums.Status;
import com.hospital.model.Patient;
import com.hospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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

    public Optional<Patient> getPatientById(Long patientId) {
        return patientRepository.findById(patientId);
    }

    public List<Patient> getPatientsByDateOfBirthBetween(LocalDate startDate, LocalDate endDate) {
        return patientRepository.findByDateOfBirthBetween(startDate, endDate);
    }
    public List<Patient> getPatientsByAdmittingDoctorDepartment(Department department) {
        return patientRepository.findByAdmittedByDepartment(department);
    }

    public List<Patient> getPatientsWithDoctorStatus(Status status) {
        return patientRepository.findByAdmittedByStatus(status);
    }
}

