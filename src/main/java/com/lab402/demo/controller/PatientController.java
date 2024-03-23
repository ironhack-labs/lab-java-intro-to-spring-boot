package com.lab402.demo.controller;

import com.lab402.demo.model.Patient;
import com.lab402.demo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("patients")
    public List<Patient> findAllPatients(){
        return patientService.findAllPatients();
    }

    @PostMapping("patients")
    public Patient addNewPatient(@RequestBody Patient patient){
        return patientService.addNewPatient(patient);
    }

    @GetMapping("patients/{id}")
    public Optional<Patient> findPatientById(@PathVariable(name="id") Integer patientId){
        return patientService.findPatientById(patientId);
    }

    @GetMapping("patients/dates")
    public List<Patient> findPatientsWithinDateRange(@RequestParam String startDate, @RequestParam String endDate){
        return patientService.findPatientsWithinDateRange(startDate, endDate);
    }

    @GetMapping("patients/departments")
    public List<Patient> findPatientsByDoctorDepartment(@RequestParam String department){
        return patientService.findPatientsByDoctorDepartment(department);
    }

    @GetMapping("patients/status")
    public List<Patient> findPatientsWithDoctorStatusOff(){
        return patientService.findPatientsWithDoctorStatusOff();
    }

}
