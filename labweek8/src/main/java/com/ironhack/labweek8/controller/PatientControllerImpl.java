package com.ironhack.labweek8.controller;

import com.ironhack.labweek8.model.EmployeeStatus;
import com.ironhack.labweek8.model.Patient;
import com.ironhack.labweek8.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/patients")
@RequiredArgsConstructor
public class PatientControllerImpl implements PatientControllerInterface {

    private final PatientService patientService;

    @Override
    @GetMapping("all")
    public List<Patient> getPatients() {
        return patientService.getAllPatients();
    }

    @Override
    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable(name = "id") int id) {
        return patientService.getPatientById(id);
    }

    @Override
    @GetMapping("birthdate")
    public List<Patient> getPatientsWithBirthdateRange(@RequestParam LocalDate from, @RequestParam LocalDate to) {
        return patientService.getPatientWithBirthdayBetween(from, to);
    }

    @Override
    @GetMapping("doctor")
    public List<Patient> getPatientsByDoctorDepartment(@RequestParam String department) {
        return patientService.getPatientByDoctorDepartment(department);
    }

    @Override
    @GetMapping("withDoctorOff")
    public List<Patient> getPatientsWithDoctorStatusOff() {
        return patientService.getPatientByDoctorStatus(EmployeeStatus.OFF);
    }


}
