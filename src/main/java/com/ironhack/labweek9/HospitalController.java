package com.ironhack.labweek9;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    @GetMapping("/doctors")
    public List<Employee> getAllDoctors() {
        return hospitalService.getAllDoctors();
    }

    @GetMapping("/doctors/{id}")
    public Employee getDoctorById(@PathVariable Long id) {
        return hospitalService.getDoctorById(id);
    }

    @GetMapping("/doctors/status/{status}")
    public List<Employee> getDoctorsByStatus(@PathVariable Status status) {
        return hospitalService.getDoctorsByStatus(status);
    }

    @GetMapping("/doctors/department/{department}")
    public List<Employee> getDoctorsByDepartment(@PathVariable String department) {
        return hospitalService.getDoctorsByDepartment(department);
    }

    @GetMapping("/patients")
    public List<Patient> getAllPatients() {
        return hospitalService.getAllPatients();
    }

    @GetMapping("/patients/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return hospitalService.getPatientById(id);
    }

    @GetMapping("/patients/dob")
    public List<Patient> getPatientsByDateOfBirthRange(@RequestParam LocalDate start, @RequestParam LocalDate end) {
        return hospitalService.getPatientsByDateOfBirthRange(start, end);
    }

    @GetMapping("/patients/department/{department}")
    public List<Patient> getPatientsByAdmittingDoctorDepartment(@PathVariable String department) {
        return hospitalService.getPatientsByAdmittingDoctorDepartment(department);
    }

    @GetMapping("/patients/doctorstatus/off")
    public List<Patient> getPatientsWithDoctorStatusOff() {
        return hospitalService.getPatientsWithDoctorStatusOff();
    }
}

