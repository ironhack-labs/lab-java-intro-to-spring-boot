package com.ironhack.demo.service;

import com.ironhack.demo.enums.Department;
import com.ironhack.demo.model.Patient;
import com.ironhack.demo.repository.PatientRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long patientId){
        return patientRepository.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with employee ID: " + patientId));
    }

    public List<Patient> getPatientsByDateOfBirthRange(LocalDate startDate, LocalDate endDate){
        return patientRepository.findPatientsByDateOfBirthRange(startDate, endDate);
    }

    public List<Patient> getPatientsByAdmittingDoctorDepartment(Department department){
        return patientRepository.findPatientsByAdmittingDoctorDepartment(department);
    }

    public List<Patient> getPatientsWithDoctorStatusOff(){
        return patientRepository.findAllPatientsWithDoctorStatusOff();
    }
}
