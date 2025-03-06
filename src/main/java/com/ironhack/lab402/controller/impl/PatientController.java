package com.ironhack.lab402.controller.impl;

import com.ironhack.lab402.controller.interfaces.IPatientController;
import com.ironhack.lab402.model.Patient;
import com.ironhack.lab402.service.impl.PatientService;
import com.ironhack.lab402.service.interfaces.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController implements IPatientController {

    @Autowired
    PatientService patientService;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Patient getPatientById(@PathVariable(name = "id") Integer patientID) {
        return patientService.getPatientById(patientID);
    }

    @GetMapping("/birth-range")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getPatientsByDateOfBirthRange(
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate) {
        return patientService.getPatientsByDateOfBirthRange(startDate, endDate);
    }

    @GetMapping("/department")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getPatientsByDoctorDepartment(@RequestParam String department) {
        return patientService.getPatientsByDoctorDepartment(department);
    }

    @GetMapping("/status-off")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getPatientsByDoctorStatusOff() {
        return patientService.getPatientsByDoctorStatusOff();
    }
}
