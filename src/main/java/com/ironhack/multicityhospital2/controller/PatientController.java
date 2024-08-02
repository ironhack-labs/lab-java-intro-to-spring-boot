package com.ironhack.multicityhospital2.controller;

import com.ironhack.multicityhospital2.model.Patient;
import com.ironhack.multicityhospital2.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Patient addNewPatient(@RequestBody Patient patient) {
        return patientService.addNewPatient(patient);
    }


    @DeleteMapping("/{patientId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePatient(@PathVariable("patientId") Long patientId) {

        patientService.deletePatient(patientId);
    }
    @GetMapping("/{patientId}")
    public Optional<Patient> getPatientById(@PathVariable("patientId") Long patientId){
        return patientService.getPatientById(patientId);
    }
    @GetMapping("/{admittedBy}")
    public Optional<Patient> getPatientByAdmittedBy(@PathVariable("admittedBy") Long admittedBy){
        return patientService.getPatientByAdmittedBy(admittedBy);
    }

    @PutMapping("/{patientId}")
    public Patient updatePatientById(@PathVariable("patientId") Long patientId,
                                   @RequestBody Patient patient){
        return patientService.updatePatientById(patientId, patient);
    }


}







