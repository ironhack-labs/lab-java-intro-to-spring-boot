package com.activity.lab4.service;


import ch.qos.logback.core.status.Status;
import com.activity.lab4.model.Patient;
import com.activity.lab4.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;

    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long ID) {
        return patientRepository.findById(ID).get();
    }

    public List<Patient> getPatientByDateOfBirthRange(Date startDate, Date endDate) {
        return patientRepository.findDateOfBirthBetween(startDate, endDate);
    }

    public List<Patient> getPatinetsByAdmittedDoctorDepartment(String department) {
        return patientRepository.findByAdmittedBy_Department(department);
    }

    public List<Patient> getPatientsByDoctorStatus(Status status) {
        return patientRepository.findByAdmittedBy_Status(status);
    }

}
