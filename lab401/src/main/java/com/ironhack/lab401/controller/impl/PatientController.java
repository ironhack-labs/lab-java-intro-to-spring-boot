package com.ironhack.lab401.controller.impl;

import com.ironhack.lab401.controller.interfaces.IPatientController;
import com.ironhack.lab401.model.Employee;
import com.ironhack.lab401.model.Patient;
import com.ironhack.lab401.service.impl.PatientService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class PatientController implements IPatientController {

    @Autowired
    PatientService patientService;

    @GetMapping("/patients")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public List<Patient> getAllPatient() {
        return patientService.getAllPatient();
    }

    @GetMapping("/patients/{patient_id}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public Patient getPatientById(@PathVariable Integer patient_id) {
        return patientService.getPatientById(patient_id);
    }

    @GetMapping("/patients/dateOfBirth")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public List<Patient> getPatientByDateOfBirthRange(@RequestParam LocalDate dateOfBirth) {
        return patientService.getPatientByDateOfBirthRange(dateOfBirth);
    }

    @GetMapping("/patients/department")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public List<Patient> getPatientByDepartmentDoctor(@RequestParam String department) {
        return patientService.getPatientByDepartmentDoctor(department);
    }

    @GetMapping("/patients/employee/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public List<Patient> getPatientWithDoctorStatusOFF(@PathVariable Integer id) {
        return patientService.getPatientWithDoctorStatusOFF(id);
    }

//    @PostMapping("/patients")
//    @ResponseStatus(HttpStatus.CREATED)
//    @Override
//    public void savePatient(Patient patient) {
//        patientService.savePatient(patient);
//    }
}
