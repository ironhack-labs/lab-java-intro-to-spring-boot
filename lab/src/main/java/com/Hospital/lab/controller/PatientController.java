package com.Hospital.lab.controller;


import com.example.hospital.model.Patient;
import com.example.hospital.service.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    private final PatientService service;

    public PatientController(PatientService service) {
        this.service = service;
    }

    @GetMapping
    public List<Patient> getAllPatients() {
        return service.getAllPatients();
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return service.getPatientById(id);
    }

    @GetMapping("/dob")
    public List<Patient> getPatientsByDateOfBirthRange(
            @RequestParam String startDate,
            @RequestParam String endDate) {
        return service.getPatientsByDateOfBirthRange(startDate, endDate);
    }

    @GetMapping("/department/{department}")
    public List<Patient> getPatientsByDoctorDepartment(@PathVariable String department) {
        return service.getPatientsByDoctorDepartment(department);
    }

    @GetMapping("/status/{status}")
    public List<Patient> getPatientsByDoctorStatus(@PathVariable String status) {
        return service.getPatientsByDoctorStatus(status);
    }
}
