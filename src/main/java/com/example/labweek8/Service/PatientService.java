package com.example.labweek8.Service;

import com.example.labweek8.Model.Patient;
import com.example.labweek8.Repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j

public class PatientService {
    private final PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(int id) {
        Optional<Patient> optional = patientRepository.findById(id);
        return optional.orElse(null);
    }

    public List<Patient> getPatientWithBirthdayBetween(LocalDate from, LocalDate to) {
        return patientRepository.findByDateOfBirthBetween(from, to);
    }

    public List<Patient> getPatientByDoctorDepartment(String department) {
        return patientRepository.findByDoctorDepartment(department);
    }

    public List<Patient> getPatientByDoctorStatus(EmployeeStatus employeeStatus) {
        return patientRepository.findByDoctorStatus(employeeStatus);
    }
}
