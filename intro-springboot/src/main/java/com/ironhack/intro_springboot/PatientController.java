package com.ironhack.intro_springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/dob-range")
    public List<Patient> getPatientsByDateOfBirthRange(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return patientService.getPatientsByDateOfBirthRange(startDate, endDate);
    }

    @GetMapping("/admitting-doctor/department")
    public List<Patient> getPatientsByAdmittingDoctorDepartment(@RequestParam String department) {
        return patientService.getPatientsByAdmittingDoctorDepartment(department);
    }

    @GetMapping("/doctor-status-off")
    public List<Patient> getPatientsWithDoctorStatusOff() {
        return patientService.getPatientsWithDoctorStatusOff();
    }
}
