package com.ironhack.labweek8.service;

import com.ironhack.labweek8.model.Employee;
import com.ironhack.labweek8.model.EmployeeStatus;
import com.ironhack.labweek8.model.Patient;
import com.ironhack.labweek8.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
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
