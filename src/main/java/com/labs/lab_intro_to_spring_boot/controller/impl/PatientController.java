package com.labs.lab_intro_to_spring_boot.controller.impl;

import com.labs.lab_intro_to_spring_boot.controller.interfaces.IPatientController;
import com.labs.lab_intro_to_spring_boot.model.Patient;
import com.labs.lab_intro_to_spring_boot.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PatientController implements IPatientController {
    @Autowired
    PatientRepository patientRepository;

    @GetMapping("/patients")
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @GetMapping("/patient/{patientId}")
    public Patient getPatientById(@PathVariable Long patientId) {
        Optional<Patient> patientOptional = patientRepository.findById(patientId);
        if (patientOptional.isEmpty()) return null;
        return patientOptional.get();
    }

    @GetMapping("/patientsByDoctorDepartment")
    public List<Patient> getPatientsByDoctorDepartment(@RequestParam String department) {
        return patientRepository.findByAdmittedByDepartment(department);
    }

    @GetMapping("/patientsByDateOfBirth")
    public List<Patient> getPatientsByDateOfBirthRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return patientRepository.findByDateOfBirthBetween(startDate, endDate);
    }

    @GetMapping("/patientsByDoctorStatus")
    public List<Patient> getPatientsByDoctorStatus(@RequestParam String status) {
        return patientRepository.findByAdmittedByStatus(status);
    }
}