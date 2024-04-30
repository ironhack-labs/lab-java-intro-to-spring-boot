package dev.svg.ih.services;

import dev.svg.ih.model.Doctor;
import dev.svg.ih.model.Patient;
import dev.svg.ih.repositories.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Optional<Patient> getPatientsById(Long id) {
        return patientRepository.findById(id);
    }

    public List<Patient> getPatientsByDateOfBirth(String dateOfBirth) {
        return patientRepository.findByDateOfBirth(dateOfBirth);
    }

    public List<Patient> getPatientsByDoctor(Doctor doctor) {
        return patientRepository.findPatientsByDoctor(doctor);
    }

    public List<Patient> getPatientsByDateOfBirthAndDoctor(String dateOfBirth, Doctor doctor) {
        return patientRepository.findByDateOfBirthAndDoctor(dateOfBirth, doctor);
    }

}
