package com.ironhack.lab.Intro.Spring.Boot.controller;

import com.ironhack.lab.Intro.Spring.Boot.Enum.Department;
import com.ironhack.lab.Intro.Spring.Boot.Enum.Status;
import com.ironhack.lab.Intro.Spring.Boot.model.Patient;
import com.ironhack.lab.Intro.Spring.Boot.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;


    @GetMapping("")
    public List<Patient> findAll(){
        return patientService.findAll();
    }

    @GetMapping("/{id}")
    public Patient findPatientById(@PathVariable String id) {
        Patient patient = patientService.findById(id);
        return patient;
    }

    @GetMapping("/by-dob")
    public List<Patient> findAllByDateOfBirthBetween(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return patientService.findAllByDateOfBirthBetween(startDate, endDate);
    }

    @GetMapping("/by-department")
    public List<Patient> findAllByEmployeeDepartment(@RequestParam("department") String department) {
        Department departmentEnum = Department.valueOf(department.toUpperCase());
       return patientService.findAllByEmployeeDepartment(departmentEnum);
    }

    @GetMapping("/by-status")
    public List<Patient> findAllByEmployeeStatus(@RequestParam("status") String status) {
        Status statusEnum = Status.valueOf(status.toUpperCase());
        return patientService.findAllByEmployeeStatus(statusEnum);
    }

    @GetMapping("/by-status-off")
    public List<Patient> findAllByEmployeeStatusOff() {
        return patientService.findAllByEmployeeStatusOff();
    }
}
