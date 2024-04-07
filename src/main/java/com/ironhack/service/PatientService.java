package com.ironhack.service;

import com.ironhack.model.Employee;
import com.ironhack.model.Patient;
import com.ironhack.model.enums.Status;
import com.ironhack.repository.EmployeeRepository;
import com.ironhack.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAll() {
        return patientRepository.findAll();
    }

    public Optional<Patient> searchByPatientId(int patientId) {
        return patientRepository.findByPatientId(patientId);
    }

    public List<Patient> getAllByDateOfBirthBetween(Date startDate, Date endDate) {
        return patientRepository.findAllByDateOfBirthBetween(startDate, endDate);
    }

    public List<Patient> getAllByAdmittedByDepartment(String department) {
        return patientRepository.findAllByAdmittedBy_Department(department);
    }



    public List<Patient> getAllByAdmittedByStatus(Status status) {
        return patientRepository.findAllByAdmittedBy_Status(status);
    }
}