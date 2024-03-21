package com.example.demo.Controllers;

import com.example.demo.Classes.Patient;
import com.example.demo.Services.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
        return patient != null ? new ResponseEntity<>(patient, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public Patient createPatient(@RequestBody Patient patient) {
        return patientService.savePatient(patient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // In PatientController.java
    @GetMapping("/dob/{start}/{end}")
    public List<Patient> getPatientsByDobRange(@PathVariable Date start, @PathVariable Date end) {
        return patientService.getPatientsByDobRange(start, end);
    }

    @GetMapping("/admitting_department/{department}")
    public List<Patient> getPatientsByAdmittingDoctorsDepartment(@PathVariable String department) {
        return patientService.getPatientsByAdmittingDoctorsDepartment(department);
    }

    @GetMapping("/doctor_off")
    public List<Patient> getPatientsWithDoctorOff() {
        return patientService.getPatientsWithDoctorOff();
    }
}
