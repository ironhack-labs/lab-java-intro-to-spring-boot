package com.ironhack.week_9_lab.controller;

import com.ironhack.week_9_lab.model.Patient;
import com.ironhack.week_9_lab.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public Optional<Patient> getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }

    @GetMapping("/dob")
    public List<Patient> getPatientsByDateOfBirthRange(@RequestParam String startDate, @RequestParam String endDate) {
        return patientService.getPatientsByDateOfBirthRange(startDate, endDate);
    }

    @GetMapping("/department/{department}")
    public List<Patient> getPatientsByDoctorDepartment(@PathVariable String department) {
        return patientService.getPatientsByDoctorDepartment(department);
    }

    @GetMapping("/doctor-status/{status}")
    public List<Patient> getPatientsByDoctorStatus(@PathVariable String status) {
        return patientService.getPatientsByDoctorStatus(status);
    }
}

