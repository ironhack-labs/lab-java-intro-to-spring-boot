package com.intro.to.springboot.Service;

import com.intro.to.springboot.Repository.PatientRepository;
import com.intro.to.springboot.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {

    public List<Patient> getPatientsByDoctorDepartment;
    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(int id) {
        return patientRepository.findById(id).orElse(null);
    }

    public List<Patient> getPatientsByDateOfBirthRange(LocalDate start, LocalDate end) {
        return patientRepository.findByDateOfBirthBetween(start, end);
    }

    public List<Patient> getPatientsByDoctorDepartment(String department) {
        return patientRepository.findAll().stream()
                .filter(patient -> patient.getAdmittedBy().getDepartment().equals(department))
                .collect(Collectors.toList());
    }

    public List<Patient> getPatientsWithDoctorStatusOff() {
        return patientRepository.findAll().stream()
                .filter(patient -> patient.getAdmittedBy().getStatus().equals("OFF"))
                .collect(Collectors.toList());
    }
}
