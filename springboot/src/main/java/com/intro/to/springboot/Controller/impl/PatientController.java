package com.intro.to.springboot.Controller.impl;

import com.intro.to.springboot.Repository.PatientRepository;
import com.intro.to.springboot.Service.PatientService;
import com.intro.to.springboot.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    PatientRepository patientRepository;

    @GetMapping("/all-patients")
    public List<com.intro.to.springboot.model.Patient> getAllPatientsFromRepository() {
        return patientRepository.findAll();
    }

    @GetMapping
    public List<com.intro.to.springboot.model.Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public com.intro.to.springboot.model.Patient getPatientById(@PathVariable int id) {
        return patientService.getPatientById(id);
    }

    @GetMapping("/dob")
    public List<Patient> getPatientsByDateOfBirthRange(@RequestParam String start, @RequestParam String end) {
        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);
        return patientService.getPatientsByDateOfBirthRange(startDate, endDate);
    }
    }

