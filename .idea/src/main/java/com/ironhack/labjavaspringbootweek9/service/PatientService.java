package com.ironhack.labjavaspringbootweek9.service;

import com.ironhack.labjavaspringbootweek9.enums.Status;
import com.ironhack.labjavaspringbootweek9.model.Patient;
import com.ironhack.labjavaspringbootweek9.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
    public Optional<Patient> getPatientById(Long id) {
        return patientRepository.findById(id);
    }
    public List<Patient> getPatientByBirthDayRange(LocalDate from, LocalDate to) {
        return patientRepository.findByDateOfBirthBetween(from,to);
    }
    public List<Patient> getPatientByDoctorsDepartment(String department) {
        return patientRepository.findByDoctorsDepartment(department);
    }
    public List<Patient> getPatientByDoctorsStatus(Status status) {
        return patientRepository.findByDoctorsStatus(status);
    }


}
