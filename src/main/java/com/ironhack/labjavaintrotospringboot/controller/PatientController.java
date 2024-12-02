package com.ironhack.labjavaintrotospringboot.controller;

import com.ironhack.labjavaintrotospringboot.enums.StatusEnum;
import com.ironhack.labjavaintrotospringboot.model.Patient;
import com.ironhack.labjavaintrotospringboot.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public Optional<Patient> getPatientByID(@PathVariable("id") int patientID) {
        return patientService.getPatientByID(patientID);
    }

    @GetMapping("/birthdate-range")
    public List<Patient> getPatientsByDateOfBirthRange(@RequestParam("first-date") LocalDate firstDate, @RequestParam("last-date") LocalDate lastDate) {
        return patientService.getPatientsByDateOfBirthRange(firstDate, lastDate);
    }

    @GetMapping("/doctor-department/{department}")
    public List<Patient> getPatientsByAdmittingDoctorsDepartment(@PathVariable("department") String department) {
        return patientService.getPatientsByAdmittingDoctorsDepartment(department);
    }

    @GetMapping("/doctor-status-off")
    public List<Patient> getAllPatientsWithADoctorWhoseStatusIsOFF() {
        return patientService.getAllPatientsWithADoctorWhoseStatusIsOFF();
    }
}
