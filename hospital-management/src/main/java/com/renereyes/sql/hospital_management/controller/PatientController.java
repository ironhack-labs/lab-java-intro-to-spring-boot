// src/main/java/com/renereyes/sql/hospitalmanagement/controller/PatientController.java
package com.renereyes.sql.hospitalmanagement.controller;

import com.renereyes.sql.hospitalmanagement.entity.Patient;
import com.renereyes.sql.hospitalmanagement.repository.PatientRepository;
import com.renereyes.sql.hospitalmanagement.repository.EmployeeRepository;
import com.renereyes.sql.hospitalmanagement.entity.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @GetMapping("/dob")
    public List<Patient> getPatientsByDateOfBirthRange(@RequestParam LocalDate start, @RequestParam LocalDate end) {
        return patientRepository.findByDateOfBirthBetween(start, end);
    }

    @GetMapping("/admitting-doctor/department/{department}")
    public List<Patient> getPatientsByAdmittingDoctorDepartment(@PathVariable String department) {
        List<Employee> doctors = employeeRepository.findByDepartment(department);
        return doctors.stream()
                .flatMap(doctor -> patientRepository.findByAdmittedBy(doctor).stream())
                .collect(Collectors.toList());
    }

    @GetMapping("/admitting-doctor/status/{status}")
    public List<Patient> getPatientsByAdmittingDoctorStatus(@PathVariable String status) {
        List<Employee> doctors = employeeRepository.findByStatus(status);
        return doctors.stream()
                .flatMap(doctor -> patientRepository.findByAdmittedBy(doctor).stream())
                .collect(Collectors.toList());
    }
}
