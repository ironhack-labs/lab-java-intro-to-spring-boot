package com.labs.lab402.controller.impl;

import com.labs.lab402.controller.interfaces.IPatientController;
import com.labs.lab402.model.Patient;
import com.labs.lab402.service.interfaces.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class PatientController implements IPatientController {

    @Autowired
    IPatientService patientService;

    @GetMapping("/patients")
    @Override
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/patients/{id}")
    @Override
    public Patient getPatientById(@PathVariable Integer id) {
        return patientService.getPatientById(id);
    }

    @GetMapping("/patients/date")
    @Override
    public List<Patient> getAllPatientsByDateOfBirthRange(
            @RequestParam("start")
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate start,
            @RequestParam("finish")
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate finish
    ) {
        return patientService.getAllPatientsByDateOfBirthRange(start, finish);
    }


    @GetMapping("patients/admitted/{department}")
    @Override
    public List<Patient> getAllPatientsByAdmittingDoctorDepartment(@PathVariable String department) {
        return patientService.getAllPatientsByAdmittingDoctorDepartment(department);
    }

    @GetMapping("patients/off")
    @Override
    public List<Patient> getAllPatientsWhoseDoctorsStatusIsOff() {
        return patientService.getAllPatientsWhoseDoctorsStatusIsOff();
    }
}
