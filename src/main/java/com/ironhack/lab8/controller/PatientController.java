package com.ironhack.lab8.controller;

import com.ironhack.lab8.model.Patient;
import com.ironhack.lab8.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/set")
    public ResponseEntity<List<Patient>> setPatients() {
        List<Patient> patients = patientService.setPatients();
        return new ResponseEntity<>(patients, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<Patient>> getPatients() {
        List<Patient> patients = patientService.getPatients();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        Patient patient = patientService.getPatientById(id);
        if (patient == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    @GetMapping("/dob/{dateOfBirth}")
    public ResponseEntity<List<Patient>> getBydateOfBirth(@PathVariable String dateOfBirth) {
        LocalDate dob = LocalDate.parse(dateOfBirth);
        List<Patient> patients = patientService.getByDateOfBirth(dob);
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/admittedBy/{admittedBy}")
    public ResponseEntity<List<Patient>> getByAdmittedBy(@PathVariable int admittedBy) {
        List<Patient> patients = patientService.getByAdmittedBy(admittedBy);
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/doctorsStatus/{status}")
    public ResponseEntity<List<Patient>> getPatientsByDoctorsStatus(@PathVariable String status) {
        List<Patient> patients = patientService.getPatientsByDoctorsStatus(status);
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }
}
