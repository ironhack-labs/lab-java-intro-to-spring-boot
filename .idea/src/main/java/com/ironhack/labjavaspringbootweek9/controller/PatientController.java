package com.ironhack.labjavaspringbootweek9.controller;

import com.ironhack.labjavaspringbootweek9.enums.Status;
import com.ironhack.labjavaspringbootweek9.model.Patient;
import com.ironhack.labjavaspringbootweek9.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public Optional<Patient> getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }

    @GetMapping("/patients/date-of-birth")
    public List<Patient> getPatientByBirthDayRange(@RequestParam LocalDate from, @RequestParam LocalDate to ) {
        return patientService.getPatientByBirthDayRange(from,to);
    }

    @GetMapping("/patients/byDoctorDepartment")
    public List<Patient> getPatientByDoctorsDepartment(@RequestParam String department) {
        return patientService.getPatientByDoctorsDepartment(department);
    }

    @GetMapping("/patients/byDoctorOff")
    public List<Patient> getPatientByDoctorsStatus(@RequestParam Status status) {
        return patientService.getPatientByDoctorsStatus(status);
    }


}