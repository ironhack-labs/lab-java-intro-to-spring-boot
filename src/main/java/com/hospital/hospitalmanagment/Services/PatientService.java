package com.hospital.hospitalmanagment.Services;

import com.hospital.hospitalmanagment.model.Patient;
import com.hospital.hospitalmanagment.model.Status;
import com.hospital.hospitalmanagment.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
        return  patientRepository.findById(id);
    }

    public List<Patient> getPatientByBirthRange(Date start, Date finish) {
        return  patientRepository.findByBirthdayBetween(start, finish);
    }

    public List<Patient> getPatientByDoctorsDepartment(String department) {
        return patientRepository.findByDoctorsDepartment(department);
    }

    public List<Patient> getPatientByDoctorsStatus(Status status) {
        return patientRepository.findByDoctorsStatus(status);

    }
}
