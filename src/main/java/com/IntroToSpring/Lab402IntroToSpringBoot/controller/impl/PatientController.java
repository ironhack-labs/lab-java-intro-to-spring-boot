package com.IntroToSpring.Lab402IntroToSpringBoot.controller.impl;

import com.IntroToSpring.Lab402IntroToSpringBoot.model.Patient;
import com.IntroToSpring.Lab402IntroToSpringBoot.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patients")
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @GetMapping("/patients/{id}")
    public Optional<Patient> getPatientById(@PathVariable Long id) {
        return patientRepository.findById(id);
    }

    @GetMapping("/patients/dob")
    public List<Patient> getPatientsByDateOfBirthRange(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return patientRepository.findByDateOfBirthBetween(startDate, endDate);
    }

    @GetMapping("/patients/doctor/department/{department}")
    public List<Patient> getPatientsByDoctorDepartment(@PathVariable String department) {
        return patientRepository.findByAdmittedBy_Department(department);
    }

    @GetMapping("/patients/doctor/status/off")
    public List<Patient> getPatientsByDoctorStatusOff() {
        return patientRepository.findByAdmittedBy_Status("OFF");
    }
}
