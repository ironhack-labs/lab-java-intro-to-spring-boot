package com.ironhack.controller;

import com.ironhack.model.Patient;
import com.ironhack.model.Status;
import com.ironhack.repository.PatientRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @GetMapping("/dob")
    public List<Patient> getPatientsByDobRange(
            @RequestParam LocalDate start,
            @RequestParam LocalDate end) {
        return patientRepository.findByDateOfBirthBetween(start, end);
    }

    @GetMapping("/department/{department}")
    public List<Patient> getPatientsByDoctorDepartment(@PathVariable String department) {
        return patientRepository.findByAdmittedByDepartment(department);
    }

    @GetMapping("/doctor-status/off")
    public List<Patient> getPatientsWithDoctorOff() {
        return patientRepository.findByAdmittedByStatus(Status.OFF);
    }
}