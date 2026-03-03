package com.ironhack.labspringinit.controller;

import com.ironhack.labspringinit.data.HospitalData;
import com.ironhack.labspringinit.model.Employee;
import com.ironhack.labspringinit.model.Patient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    // Get all patients
    @GetMapping
    public List<Patient> getAllPatients() {
        return HospitalData.patients.values().stream().toList();
    }

    // Get patient by ID
    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable int id) {
        return HospitalData.patients.get(id);
    }

    // Get patients by DOB range (STRING COMPARISON)
    @GetMapping("/dob")
    public List<Patient> getPatientsByDobRange(
            @RequestParam String start,
            @RequestParam String end) {

        return HospitalData.patients.values().stream()
                .filter(p ->
                        p.getDateOfBirth().compareTo(start) >= 0 &&
                                p.getDateOfBirth().compareTo(end) <= 0
                )
                .toList();
    }


    @GetMapping("/department/{department}")
    public List<Patient> getPatientsByDoctorDepartment(
            @PathVariable String department) {

        return HospitalData.patients.values().stream()
                .filter(p -> {
                    Employee doctor =
                            HospitalData.employees.get(p.getAdmittedBy());
                    return doctor != null &&
                            doctor.getDepartment().equalsIgnoreCase(department);
                })
                .toList();
    }


    @GetMapping("/doctor-status/off")
    public List<Patient> getPatientsWithDoctorOff() {

        return HospitalData.patients.values().stream()
                .filter(p -> {
                    Employee doctor =
                            HospitalData.employees.get(p.getAdmittedBy());
                    return doctor != null &&
                            doctor.getStatus().equalsIgnoreCase("OFF");
                })
                .toList();
    }
}