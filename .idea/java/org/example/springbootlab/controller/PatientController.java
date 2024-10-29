package org.example.springbootlab.controller;

import org.example.springbootlab.model.Patient;
import org.example.springbootlab.services.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        Patient patient = patientService.getPatientById(id);
        return patient != null ? ResponseEntity.ok(patient) : ResponseEntity.notFound().build();
    }

    @GetMapping("/dob-range")
    public List<Patient> getPatientsByDateOfBirthRange(@RequestParam String startDate, @RequestParam String endDate) {
        return patientService.getPatientsByDateOfBirthRange(startDate, endDate);
    }

    @GetMapping("/department/{department}")
    public List<Patient> getPatientsByDoctorDepartment(@PathVariable String department) {
        return patientService.getPatientsByDoctorDepartment(department);
    }

    @GetMapping("/doctor-status-off")
    public List<Patient> getPatientsByDoctorStatusOff() {
        return patientService.getPatientsByDoctorStatusOff();
    }
}