package com.example.intro.controller;

import com.example.intro.model.Patient;
import com.example.intro.model.utils.Status;
import com.example.intro.service.PatientService;
import jakarta.persistence.EnumType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RestController
public class PatientController {
    @Autowired
    PatientService patientService;

    @GetMapping("/patients")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/patients/{id}")
    public Optional<Patient> getPatientById(@PathVariable(name = "id") int id) {
        return patientService.getPatientById(id);
    }

    @GetMapping("/patients/byDates")
    public List<Patient> getPatientByDates(@RequestParam String startDate, @RequestParam String endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            LocalDate startDateObj = LocalDate.parse(startDate, formatter);
            LocalDate endDateObj = LocalDate.parse(endDate, formatter);
            return patientService.getPatientsByDate(startDateObj, endDateObj);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/patients/byDoctorDepartment")
    public List<Patient> getPatientByDoctorDepartment(@RequestParam String doctorDepartment) {
        return patientService.getPatientByDoctorDepartment(doctorDepartment);
    }

    @GetMapping("/patients/byDoctorOff")
    public List<Patient> getPatientByDoctorOff() {
        return patientService.getPatientByDoctorStatus(Status.OFF);
    }
}
