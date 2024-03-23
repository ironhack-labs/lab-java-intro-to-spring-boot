package com.lab402.demo.service;

import com.lab402.demo.model.Patient;
import com.lab402.demo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> findAllPatients(){
        return patientRepository.findAll();
    }

    public Patient addNewPatient(Patient patient){
        return patientRepository.save(patient);
    }

    public Optional<Patient> findPatientById(Integer patientId){
        return patientRepository.findById(patientId);
    }

    public List<Patient> findPatientsWithinDateRange(String startDate, String endDate) {
        LocalDate parsedStartDate = LocalDate.parse(startDate, DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate parsedEndDate = LocalDate.parse(endDate, DateTimeFormatter.ISO_LOCAL_DATE);
        return patientRepository.findByDateOfBirthWithinRange(parsedStartDate, parsedEndDate);
    }

    public List<Patient> findPatientsByDoctorDepartment(String department){
        return patientRepository.findPatientsByDoctorDepartment(department);
    }

    public List<Patient> findPatientsWithDoctorStatusOff(){
        return patientRepository.findPatientsWithDoctorStatusOff();
    }


}
