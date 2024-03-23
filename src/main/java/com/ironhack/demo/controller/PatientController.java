package com.ironhack.demo.controller;

import com.ironhack.demo.enums.Department;
import com.ironhack.demo.enums.Status;
import com.ironhack.demo.model.Patient;
import com.ironhack.demo.service.EmployeeService;
import com.ironhack.demo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping("")
    public List<Patient> getAllPatients(){
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public Patient findPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }

    @GetMapping("/by-dob")
    public List<Patient> getPatientsByDateOfBirthRange(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return patientService.getPatientsByDateOfBirthRange(startDate, endDate);
    }

    @GetMapping("/by-department")
    public List<Patient> getPatientsByAdmittingDoctorDepartment(@RequestParam("department") String department) {
        Department departmentEnum = Department.valueOf(department.toUpperCase());
        return patientService.getPatientsByAdmittingDoctorDepartment(departmentEnum);
    }

    @GetMapping("/by-status-off")
    public List<Patient> getPatientsWithDoctorStatusOff() {
        return patientService.getPatientsWithDoctorStatusOff();
    }
}
