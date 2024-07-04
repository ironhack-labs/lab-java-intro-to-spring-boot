package com.example.get.controller;


import com.example.get.model.Patient;
import com.example.get.repository.EmployeeRepository;
import com.example.get.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable("id") Integer id) {
        Optional<Patient> patient = patientRepository.findById(id);
        return patient.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/dob")
    public List<Patient> getPatientsByDateOfBirthRange(@RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
                                                       @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        return patientRepository.findByDateOfBirthBetween(start, end);
    }

    @GetMapping("/employee-department/{department}")
    public List<Patient> getPatientsByAdmittingEmployeeDepartment(@PathVariable("department") String department) {
        return patientRepository.findByAdmittingEmployee_Department(department);
    }

    @GetMapping("/employee-status/OFF")
    public List<Patient> getPatientsByEmployeeStatusOff() {
        return patientRepository.findByAdmittingEmployee_Status("OFF");
    }
}
