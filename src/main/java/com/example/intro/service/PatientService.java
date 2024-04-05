package com.example.intro.service;

import com.example.intro.model.Patient;
import com.example.intro.model.utils.Status;
import com.example.intro.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Optional<Patient> getPatientById(int id) {
        return patientRepository.findPatientById(id);
    }

    public List<Patient> getPatientsByDate(LocalDate startDate, LocalDate endDate) {
        return patientRepository.findPatientsWithDateOfBirthBetween(startDate, endDate);
    }

    public List<Patient> getPatientByDoctorDepartment(String doctorDepartment) {
        return patientRepository.findPatientsByEmployeeDepartment(doctorDepartment);
    }

    public List<Patient> getPatientByDoctorStatus(Status status) {
        return patientRepository.findPatientsByEmployeeStatus(status);
    }
}
