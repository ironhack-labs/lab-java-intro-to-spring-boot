package com.example.lab_java_intro_to_spring_boot.controller;

import com.example.lab_java_intro_to_spring_boot.model.Patient;
import com.example.lab_java_intro_to_spring_boot.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final DataService dataService;

    @Autowired
    public PatientController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping
    public Collection<Patient> getAllPatients() {
        return dataService.getAllPatients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable int id) {
        Patient patient = dataService.getPatientById(id);
        if (patient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(patient);
    }

    @GetMapping("/date-of-birth")
    public Collection<Patient> getPatientsByDateOfBirthRange(
            @RequestParam String startDate,
            @RequestParam String endDate) {
        return dataService.getPatientsByDateOfBirthRange(startDate, endDate);
    }

    @GetMapping("/doctor/department/{department}")
    public Collection<Patient> getPatientsByDoctorDepartment(@PathVariable String department) {
        return dataService.getPatientsByDoctorDepartment(department);
    }

    @GetMapping("/doctor/status/off")
    public Collection<Patient> getPatientsWithDoctorStatusOff() {
        return dataService.getPatientsWithDoctorStatusOff();
    }
}