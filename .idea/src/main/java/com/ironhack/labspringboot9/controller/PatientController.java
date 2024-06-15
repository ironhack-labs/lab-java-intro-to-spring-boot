package com.ironhack.labspringboot9.controller;

import com.ironhack.labspringboot9.enums.Status;
import com.ironhack.labspringboot9.model.Patient;
import com.ironhack.labspringboot9.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patients")

public class PatientController {
    @Autowired
    private PatientService patientService;
    @GetMapping
    public List<Patient> getAllPatients(){
        return patientService.getAllPatients();
    }
    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id){
        return patientService.getPatientById(id);
    }
    @GetMapping("/patients/DOB")
    public List<Patient> getPatientByDateOfBirthRangeBetween(@RequestParam Date from,@RequestParam Date to){
        return patientService.getPatientByDateOfBirthRange(from, to);

    }
    @GetMapping("/Department")
    public List<Patient>getPatientByDoctorsDepartment(@RequestParam String department){
        return patientService.getPatientByDoctorsDepartment(department);
    }
    @GetMapping("/DoctorStatus")
    public List<Patient>getPatientByDoctorStatus(@RequestParam Status status){
        return patientService.getPatientByDoctorStatus(status);
    }
}
