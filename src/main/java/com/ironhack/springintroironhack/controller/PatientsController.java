package com.ironhack.springintroironhack.controller;

import com.ironhack.springintroironhack.dto.PatientResponse;
import com.ironhack.springintroironhack.model.Department;
import com.ironhack.springintroironhack.model.EmployeeStatus;
import com.ironhack.springintroironhack.service.PatientService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1/patients")
public class PatientsController {
    private final PatientService patientService;

    public PatientsController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public ResponseEntity<List<PatientResponse>> getAllPatients() {
        return ResponseEntity.ok(patientService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientResponse> getPatientById(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(patientService.getById(id));
    }

    @GetMapping(params = {"from", "to"})
    public ResponseEntity<List<PatientResponse>> getPatientsByDateOfBirthRange(
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            @RequestParam LocalDate from,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            @RequestParam LocalDate to
    ) {
        return ResponseEntity.ok(patientService.getByDateOfBirthRange(from, to));
    }

    @GetMapping(params = {"department"})
    public ResponseEntity<List<PatientResponse>> getPatientsByDepartment(
            @RequestParam Department department
    ) {
        return ResponseEntity.ok(patientService.getByAdmittingDoctorDepartment(department));
    }

    @GetMapping(params = {"status"})
    public ResponseEntity<List<PatientResponse>> getPatientsByDoctorStatus(
            @RequestParam EmployeeStatus status
    ) {
        return ResponseEntity.ok(patientService.getByAdmittingDoctorStatus(status));
    }
}
