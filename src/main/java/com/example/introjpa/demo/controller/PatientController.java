package com.example.introjpa.demo.controller;

import com.example.introjpa.demo.model.Patient;
import com.example.introjpa.demo.model.Status;
import com.example.introjpa.demo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientController {
    @Autowired
    PatientService patientService;

    @GetMapping("/patient")
    public List<Patient> getAllPatients(){
        return patientService.getAllPatient();
    }

    @GetMapping("/patient/admittedBy")
    public List<Patient> getAllByAdmittedDoctor(@RequestParam(name = "admitted_by") Integer admittedDoctor){
        return patientService.getAllByAdmittedDoctor(admittedDoctor);
    }

    @GetMapping("/patient/status")
    public List<Patient> getAllByDoctorStatusOff(){
        return patientService.getAllByDoctorStatus(Status.OFF);
    }
}
