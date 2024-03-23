package com.gets.service;

import com.gets.Enums.Status;
import com.gets.model.Patient;
import com.gets.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepo patientRepo;

    public List<Patient> findAll() {
        return patientRepo.findAll();
    }

    public Optional<Patient> getPatientById(int id) {
        return patientRepo.findById(id);
    }

    public List<Patient> getPatientsByDateOfBirthRange(LocalDate startDate, LocalDate endDate){
        return patientRepo.findPatientsByDateOfBirthRange(startDate, endDate);
    }

    public List<Patient> getPatientsByDoctorDepartment(String department) {
        return patientRepo.findPatientsByEmployeeDepartment(department);
    }

    public List<Patient> getPatientsByDoctorStatus(Status status) {
        return patientRepo.findPatientsByEmployeeStatus(status);
    }
}
