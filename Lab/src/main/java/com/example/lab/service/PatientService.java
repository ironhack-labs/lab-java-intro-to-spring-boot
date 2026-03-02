package com.example.lab.service;

import com.example.lab.exception.ResourceNotFoundException;
import com.example.lab.model.Patient;
import com.example.lab.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;
    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }
    public Patient getPatientById(Long id){
        return patientRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Patient with this id not found"));
    }
    public List<Patient> getPatientsByBirthRange(LocalDate start, LocalDate end){
        return patientRepository.findByDateOfBirthBetween(start,end).orElseThrow(()-> new ResourceNotFoundException("Patients with this birth range not found"));
    }
    public List<Patient> getPatientsByDoctorDepartment(String department){
        return patientRepository.findByAdmittedByDepartment(department).orElseThrow(()-> new ResourceNotFoundException("Patients with this admitting doctor's department not found"));
    }
    public List<Patient> getPatientsWithDoctorStatusOFF(){
        return  patientRepository.findByAdmittedByStatus("OFF").orElseThrow(()-> new ResourceNotFoundException("Patients with admitting doctor whose status is OFF not found"));
    }

}
