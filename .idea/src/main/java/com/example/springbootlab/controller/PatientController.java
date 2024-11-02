package com.example.springbootlab.controller;

import com.example.springbootlab.model.Patient;
import com.example.springbootlab.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/dob-range")
    public List<Patient> getPatientsByDateOfBirthRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return patientService.getPatientsByDateOfBirthRange(startDate, endDate);
    }

    @GetMapping("/by-doctor-department/{department}")
    public List<Patient> getPatientsByAdmittingDoctorDepartment(@PathVariable String department) {
        return patientService.getPatientsByAdmittingDoctorDepartment(department);
    }

    @GetMapping("/doctor-off")
    public List<Patient> getPatientsWithDoctorStatusOff() {
        return patientService.getPatientsWithDoctorStatusOff();
    }
}