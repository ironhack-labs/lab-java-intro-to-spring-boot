package com.ironhack.week9_lab.controller;

import com.ironhack.week9_lab.model.Patient;
import jdk.jshell.Snippet;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Service
@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {

@Autowired
    private  PatientService patientService;

    @GetMapping
    public List<Patient> getAllPatients() {
        return PatientService.findAll();
    }
    @GetMapping("/{id}")
   public Optional<Patient> getPatientsById(@PathVariable long Id) {
        return patientService.getPatientById(Id);
    }
    @GetMapping("/patients/date-of-birth")
    public List<Patient> getPatientsByBirthDayRange(@RequestParam LocalDate from, @RequestParam LocalDate to) {
        return patientService.getPatientsByBirthDayRange(from, to);
    }
    @GetMapping("/patients/byDoctorDepartment")
    public List<Patient> getPatientsByDoctorDepartment(@RequestParam String department) {
        return patientService.getPatientsByDoctorDepartment(department);
    }
    @GetMapping("/patients/byDoctorOff")
    public List<Patient> getPatientsByDoctorStatus(@RequestParam Snippet.Status status) {
        return patientService.getPatientsByDoctorStatus(status);
    }





}
