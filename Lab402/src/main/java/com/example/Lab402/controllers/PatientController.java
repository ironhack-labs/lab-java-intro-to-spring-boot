package com.example.Lab402.controllers;


import com.example.Lab402.enums.EmployeeStatus;
import com.example.Lab402.models.Patient;
import com.example.Lab402.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;


    @GetMapping("/patients")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @GetMapping("/patients/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Patient findById(@PathVariable Integer id) {
        return patientRepository.findById(id).get();
    }

    @GetMapping("/patients/birth-date")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> findByBirthDate(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)Date start, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)Date end) {
        return patientRepository.findByBirthDate(start, end);
    }

    @GetMapping("/patient/doctor-department/{department}")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> findByDoctorDepartment(@PathVariable String department) {
        return patientRepository.findByDepartmentAdmittedTo(department);
    }

    @GetMapping("/patient/off-doctor")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> findByOffDoctor() {
        return patientRepository.findByOffDoctor(EmployeeStatus.OFF);
    }
}
