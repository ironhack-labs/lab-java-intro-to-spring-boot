package com.example.lab_java_intro_to_spring_boot.controller.input;

import com.example.lab_java_intro_to_spring_boot.controller.interfaces.IPatientController;
import com.example.lab_java_intro_to_spring_boot.model.Employee;
import com.example.lab_java_intro_to_spring_boot.model.Patient;
import com.example.lab_java_intro_to_spring_boot.model.Status;
import com.example.lab_java_intro_to_spring_boot.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class PatientController implements IPatientController {

    @Autowired
    PatientRepository patientRepository;

    @GetMapping("/patient")

    public List<Patient> getAllPatient() {
        return patientRepository.findAll();
    }

    @GetMapping("/patient/{id}")
    public Patient getPatientId(@PathVariable Integer id) {

        Optional<Patient> patientOptional = patientRepository.findById(id);
        if (patientOptional.isEmpty()) return null;
        return patientOptional.get();
    }

    @GetMapping("/patient/{dateOfBirth}")
    public List<Patient> getPatientByDateOfBirth(LocalDate dateOfBirth) {
        return patientRepository.findAllByDateOfBirth(dateOfBirth);
    }

    @GetMapping("/patient/{admittedby")
    public List<Patient> getPatientByAdmittedBy(Employee employee) {
        return patientRepository.findAllByAdmittedBy(employee);
   /*
    @GetMapping("patient/{statusoff}")
    public List<Patient> getPatientByStatus(String name, @RequestParam(defaultValue = "OFF") Status status){
        if (status.equals(Status.OFF)) return patientRepository.findAllPatientByStatusParms(name, status);
        return patientRepository.findAllByStatus(status);
    }

    @GetMapping("patient/{admittedBySamOrtega}")
    public List<Patient> getPatientByAdmittedBy(@RequestParam(defaultValue = "564134") Employee name) {
        return patientRepository.findAllByAdmittedBy(name);*/
    }
}