package com.ironhack.week9lab.service;

import com.ironhack.week9lab.model.EmployeeStatus;
import com.ironhack.week9lab.model.Patient;
import com.ironhack.week9lab.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    public List<Patient>getAllPatients(){
        return patientRepository.findAll();
    }
    public Optional<Patient> getPatientById(int id){
        return patientRepository.findById(id);
    }

    public List<Patient>getByPatientDateOfBirthRange(LocalDate from, LocalDate to){
        return patientRepository.findByDateOfBirthBetween(from, to);
    }

    public List<Patient>getByPatientAdmittedByEmployeeDepartment(String department){
        return patientRepository.findByAdmittedBy_Department(department);

    }

    public List<Patient>getPatientByEmployeeStatusOff(EmployeeStatus status){
        return patientRepository.findByAdmittedBy_Status(EmployeeStatus.OFF);
    }

}
