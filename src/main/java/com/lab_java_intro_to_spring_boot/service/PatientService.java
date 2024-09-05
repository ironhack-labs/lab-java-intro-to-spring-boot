package com.lab_java_intro_to_spring_boot.service;

import com.lab_java_intro_to_spring_boot.Enums.EmployeeDepartment;
import com.lab_java_intro_to_spring_boot.Enums.EmployeeStatus;
import com.lab_java_intro_to_spring_boot.model.Patient;
import com.lab_java_intro_to_spring_boot.repository.EmployeeRepository;
import com.lab_java_intro_to_spring_boot.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Patient> getAll(){
        return patientRepository.findAll();
    }

    public Optional<Patient> getById(Long id){
        return patientRepository.findById(id);
    }

    public List<Patient> getByDateOfBirthBetween(LocalDate startDate, LocalDate endDate ){
        return patientRepository.findByDateOfBirthBetween(startDate,endDate);
    }

    public List<Patient> getByEmployeeDepartment(EmployeeDepartment department){
        return patientRepository.findByEmployeeDepartment(department);
    }

    public List<Patient> getByEmployeeStatus(EmployeeStatus status){
        return patientRepository.findByEmployeeStatus(status);
    }
}
