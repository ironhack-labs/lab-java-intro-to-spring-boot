package com.ironhack.week9lab.controller;

import com.ironhack.week9lab.model.EmployeeStatus;
import com.ironhack.week9lab.model.Patient;
import com.ironhack.week9lab.service.PatientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/patients")
public class PatientController {
    private final PatientService patientService;

    @GetMapping
    public List<Patient>getAllPatients(){
        return patientService.getAllPatients();
    }

    @GetMapping ("/{id}")
    public Optional<Patient>getPatientById(@PathVariable int id){
        return patientService.getPatientById(id);
    }

    @GetMapping("patients/date-of-birth")
    public List<Patient>getPatientByBirthDayRange(@RequestParam LocalDate from,@RequestParam LocalDate to){
        return patientService.getByPatientDateOfBirthRange(from, to);
    }

    @GetMapping("patients/byDoctorDepartment")
    public List<Patient>getPatientByDoctorDepartment(@RequestParam String department){
        return patientService.getByPatientAdmittedByEmployeeDepartment(department);
    }

    @GetMapping("patients/byDoctorOff")
    public List<Patient>getPatientByDoctorStatus(@RequestParam EmployeeStatus status){
        return patientService.getPatientByEmployeeStatusOff(status);
    }






}
