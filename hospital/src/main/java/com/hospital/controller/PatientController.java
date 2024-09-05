package com.hospital.controller;

import com.hospital.enums.Department;
import com.hospital.enums.Status;
import com.hospital.model.Patient;
import com.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    public Optional<Patient> getPatientById(@PathVariable("id") Long patientId) {
        return patientService.getPatientById(patientId);
    }

    @GetMapping("/dateOfBirth")
    public List<Patient> getPatientsByDateOfBirthBetween(
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate
    ){
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        return patientService.getPatientsByDateOfBirthBetween(start, end);
    }

    @GetMapping("/admittedBy/department/{department}")
    public List<Patient> getPatientsByAdmittingDoctorDepartment(@PathVariable("department") Department department) {
        return patientService.getPatientsByAdmittingDoctorDepartment(department);
    }

    @GetMapping("/admittedBy/status/{status}")
    public List<Patient> getPatientsWithDoctorStatus(@PathVariable("status") Status status) {
        return patientService.getPatientsWithDoctorStatus(status);
    }
}

