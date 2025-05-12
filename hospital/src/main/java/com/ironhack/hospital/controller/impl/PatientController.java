package com.ironhack.hospital.controller.impl;

import com.ironhack.hospital.model.Patient;
import com.ironhack.hospital.model.Employee.Status;
import com.ironhack.hospital.repository.PatientRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PatientController {
    @Autowired
    PatientRepository patientRepository;

    @GetMapping("/patients")
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @GetMapping("/patient/{id}")
    public Patient getPatientById(@PathVariable Integer id) {
        Optional<Patient> patientOptional = patientRepository.findById(id);
        if (patientOptional.isEmpty())
            return null;
        return patientOptional.get();
    }

    @GetMapping("/patient/birth/{startDate}/{endDate}")
    public List<Patient> getPatientsByDateOfBirth(
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return patientRepository.findByDateOfBirthBetween(startDate, endDate);
    }

    @GetMapping("/patient/by-department/{department}")
    public ResponseEntity<List<Patient>> getPatientsByDoctorDepartment(
            @PathVariable String department) {
        List<Patient> patients = patientRepository.findByAdmittedByDepartment(department);
        return patients.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(patients);
    }

    @GetMapping("/patient/by-status/{status}")
    public ResponseEntity<List<Patient>> getPatientsByDoctorStatus(
            @PathVariable Status status) {
        List<Patient> patients = patientRepository.findByAdmittedByStatus(status);
        return patients.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(patients);
    }

    @GetMapping("/patient/by-offstatus")
    public ResponseEntity<List<Patient>> getPatientsByDoctorStatus() {
        List<Patient> patients = patientRepository.findByAdmittedByStatus(Status.OFF);
        return patients.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(patients);
    }
}