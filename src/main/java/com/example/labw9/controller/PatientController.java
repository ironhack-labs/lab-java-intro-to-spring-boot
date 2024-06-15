package com.example.labw9.controller;

import com.example.labw9.enums.Status;
import com.example.labw9.model.Patient;
import com.example.labw9.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Date;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @GetMapping("/dateOfBirth")
    public List<Patient> getPatientsByDateOfBirthRange(
            @RequestParam("start") @DateTimeFormat(pattern = "yyyy-MM-dd") Date start,
            @RequestParam("end") @DateTimeFormat(pattern = "yyyy-MM-dd") Date end) {
        return patientRepository.findByDateOfBirthBetween((java.sql.Date) start, (java.sql.Date) end);
    }

    @GetMapping("/admittedByDepartment/{department}")
    public List<Patient> getPatientsByAdmittingDoctorDepartment(@PathVariable String department) {
        return patientRepository.findByAdmittedBy_Department(department);
    }

    @GetMapping("/admittedByStatus/OFF")
    public List<Patient> getPatientsByDoctorStatusOff() {
        return patientRepository.findByAdmittedBy_Status(String.valueOf(Status.OFF));
    }
}