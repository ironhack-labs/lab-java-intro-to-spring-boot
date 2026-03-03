package com.ironhack.labspringboot.controller;

import com.ironhack.labspringboot.entity.Patient;

import com.ironhack.labspringboot.service.HospitalManager;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
public class PatientController {

    private HospitalManager hospitalManager;

    public  PatientController(HospitalManager hospitalManager) {
        this.hospitalManager = hospitalManager;
    }


    @GetMapping("/allPatients")
    public List<Patient> getAllPatients() {
        return hospitalManager.getAllPatients();
    }

    @GetMapping("/patients/byID/{id}")
    public Patient getPatientByID(@PathVariable int id) {
        return hospitalManager.getPatientByID(id);
    }

    @GetMapping("/patients/byBirthRange")
    public List<Patient> getPatientByDateOfBirthRange(@RequestParam String startDate, @RequestParam String endDate) {


       return  hospitalManager.getPatientByDateOfBirthRange(startDate, endDate);
    }

    @GetMapping("/patients/byAdmittingDoctorsDepartment/{department}")
    public List<Patient> getPatientByAdmittingDoctorsDepartment(@PathVariable String department) {
        return hospitalManager.getPatientByAdmittingDoctorsDepartment(department);
    }

    @GetMapping("/allPatients/byDoctorStatusOFF/")
    public List<Patient> getPatientsByDoctorStatusOFF() {
        return hospitalManager.getPatientsByDoctorStatusOFF();
    }

}
