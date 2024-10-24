package com.activity.lab4.controller;


import ch.qos.logback.core.status.Status;
import com.activity.lab4.model.Patient;
import com.activity.lab4.service.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/patients")

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
    public Patient getPatientById(@PathVariable Long ID) {
        return patientService.getPatientById(ID);
    }

    @GetMapping("/dob")
    public List<Patient> getPatientByDateOfBirth(@RequestParam Date startDate, @RequestParam Date endDate) {
        return patientService.getPatientByDateOfBirthRange(startDate, endDate);
    }

    @GetMapping("/department/{department}")
    public List<Patient> getPatientByAdmittedDoctorDepartment(@PathVariable String department) {
        return patientService.getPatinetsByAdmittedDoctorDepartment(department);
    }

    @GetMapping("/doctor-status/{status}")
    public List<Patient> getPatientByDoctorStatus(@PathVariable Status status) {
        return patientService.getPatientsByDoctorStatus(status);

    }
}
