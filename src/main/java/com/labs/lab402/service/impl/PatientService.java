package com.labs.lab402.service.impl;

import com.labs.lab402.model.Patient;
import com.labs.lab402.repository.PatientRepository;
import com.labs.lab402.service.interfaces.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService implements IPatientService {
    @Autowired
    PatientRepository patientRepository;


    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(Integer id) {
        Optional<Patient> patientOptional = patientRepository.findById(id);
        if(patientOptional.isEmpty()) return null;
        return patientOptional.get();
    }

    @Override
    public List<Patient> getAllPatientsByDateOfBirthRange(LocalDate startDate, LocalDate finishDate) {
        return patientRepository.getAllByDateOfBirthBetween(startDate, finishDate);
    }

    @Override
    public List<Patient> getAllPatientsByAdmittingDoctorDepartment(String department) {
        return patientRepository.getAllByDoctorDepartment(department);
    }

    @Override
    public List<Patient> getAllPatientsWhoseDoctorsStatusIsOff() {
        return patientRepository.getAllByDoctorsStatusIsOff();
    }
}
