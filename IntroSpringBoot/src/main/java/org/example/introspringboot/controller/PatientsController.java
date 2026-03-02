package org.example.introspringboot.controller;

import org.example.introspringboot.Data.InMemoryDb;
import org.example.introspringboot.model.Patient;
import org.example.introspringboot.model.Status;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientsController {

    private final InMemoryDb db;

    public PatientsController(InMemoryDb db) {
        this.db = db;
    }

    @GetMapping
    public List<Patient> getAllPatients() {
        return db.getAllPatients().stream().toList();
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<Patient> getPatientById(@PathVariable int patientId) {
        var p = db.getPatientById(patientId);
        if (p == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(p);
    }

    @GetMapping("/dob")
    public List<Patient> getPatientsByDobRange(
            @RequestParam LocalDate from,
            @RequestParam LocalDate to
    ) {
        return db.getAllPatients().stream()
                .filter(p -> !p.getDateOfBirth().isBefore(from) && !p.getDateOfBirth().isAfter(to))
                .toList();
    }

    @GetMapping("/admitting-doctor/department/{department}")
    public List<Patient> getPatientsByAdmittingDoctorDepartment(@PathVariable String department) {
        String dep = department.toLowerCase();

        return db.getAllPatients().stream()
                .filter(p -> {
                    var doc = db.getEmployeeById(p.getAdmittedBy());
                    return doc != null && doc.getDepartment().equalsIgnoreCase(dep);
                })
                .toList();
    }

    @GetMapping("/admitting-doctor/status/{status}")
    public List<Patient> getPatientsByAdmittingDoctorStatus(@PathVariable Status status) {
        return db.getAllPatients().stream()
                .filter(p -> {
                    var doc = db.getEmployeeById(p.getAdmittedBy());
                    return doc != null && doc.getStatus() == status;
                })
                .toList();
    }
}