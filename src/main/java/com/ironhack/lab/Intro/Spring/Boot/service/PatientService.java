package com.ironhack.lab.Intro.Spring.Boot.service;

import com.ironhack.lab.Intro.Spring.Boot.Enum.Department;
import com.ironhack.lab.Intro.Spring.Boot.Enum.Status;
import com.ironhack.lab.Intro.Spring.Boot.model.Patient;
import com.ironhack.lab.Intro.Spring.Boot.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService  {
    @Autowired
    private PatientRepository patientRepository;


    public List<Patient> findAll() {return patientRepository.findAll();}

    public Patient findById(String id) {
        try {
            Optional<Patient> patientFound = patientRepository.findById(Long.parseLong(id));
            if (patientFound.isPresent()) {
                return patientFound.get();
            } else {
                throw new ChangeSetPersister.NotFoundException();
            }
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while finding the patient");
        }
    }


    public List<Patient> findAllByDateOfBirthBetween(LocalDate startDate, LocalDate endDate) {
        try{
            return patientRepository.findByDateOfBirthBetween(startDate, endDate);
        }catch (Exception e){
            throw new RuntimeException("An error occurred while finding the patients");
        }

    }

    public List<Patient> findAllByEmployeeDepartment(Department department) {
            return patientRepository.findAllByEmployeeDepartment(department);
    }

    public List<Patient> findAllByEmployeeStatus(Status status) {
            return patientRepository.findAllByEmployeeStatus(status);
    }
    public List<Patient> findAllByEmployeeStatusOff() {
            return patientRepository.findAllByEmployeeStatusOff();
    }
}
