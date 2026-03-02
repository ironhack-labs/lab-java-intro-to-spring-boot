package com.example.demo.controller;

import com.example.demo.model.Patient;
import com.example.demo.service.HospitalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * REST controller for managing hospital patients.
 */
@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final HospitalService hospitalService;

    @Autowired
    public PatientController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }
// Give you all patients data
    @GetMapping
    public List<Patient> getAllPatients() {
        return hospitalService.getAllPatients();
    }

//    Give you patient according to id
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        return hospitalService.getPatientById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
// Give you patient data with specific range od date of birth
    @GetMapping("/range")
    public List<Patient> getByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        return hospitalService.getPatientsByDateRange(start, end);
    }

//    Give you patient data with specific doctors department
    @GetMapping("/by-doctor-department/{dept}")
    public List<Patient> getByDoctorDepartment(@PathVariable String dept) {
        return hospitalService.getPatientsByDoctorDepartment(dept);
    }
//    Give you patient data with specific doctors status
    @GetMapping("/by-doctor-status/{status}")
    public List<Patient> getByDoctorStatus(@PathVariable String status) {
        return hospitalService.getPatientsByDoctorStatus(status);
    }


}