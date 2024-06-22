package com.ironhack.springboot.service;

import com.ironhack.springboot.model.Patient;
import com.ironhack.springboot.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PatientService {

    private final PatientRepository patientRepository;

    //    Get all patients: Create a route to get all patients.
    public List<Patient> getAllPatients() {
        log.info("Getting all patients");
        return patientRepository.getAllPatients();
    }

    //    Get patient by ID: Create a route to get a patient by patient_id.
    public Optional<Patient> getPatientById(Long id) {
        log.info("Getting patient by id {}", id);
        return patientRepository.findById(id);
    }

    //    Get patients by date of birth range: Create a route to get patients date of birth within a specified range.
    public List<Patient> getPatientsByDateOfBirthRange(String dateOfBirthStart, String dateOfBirthEnd) {
        log.info("Getting patients by date of birth range");
        return patientRepository.getPatientsByDateOfBirthRange(dateOfBirthStart, dateOfBirthEnd);
    }

    //    Get patients by admitting doctor's department: Create a route to get patients by the department that their admitting doctor is in (For example, get all patients admitted by a doctor in cardiology).
    public List<Patient> getPatientsByAdmittingDoctorDepartment(String department) {
        log.info("Getting patients by admitting doctor's department");
        return patientRepository.getPatientsByAdmittingDoctorDepartment(department);
    }

    //    Get all patients with a doctor whose status is OFF: Create a route to get all patients with a doctor whose status is OFF.
    public List<Patient> getPatientsWithDoctorOff() {
        log.info("Getting all patients with a doctor whose status is OFF");
        return patientRepository.getPatientsWithDoctorOff();
    }

}
