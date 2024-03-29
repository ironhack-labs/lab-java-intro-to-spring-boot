package com.ironhack.labjavaintrotospringboot.controller;

import com.ironhack.labjavaintrotospringboot.model.user.Department;
import com.ironhack.labjavaintrotospringboot.model.user.DoctorStatus;
import com.ironhack.labjavaintrotospringboot.model.user.Patient;
import com.ironhack.labjavaintrotospringboot.repository.PatientRepository;
import com.ironhack.labjavaintrotospringboot.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.nio.file.ReadOnlyFileSystemException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patients")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/patients/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Patient getPatientById(@PathVariable(name = "id") int patientId) {
        Optional<Patient> $patient = patientRepository.findById((patientId));
        if ($patient.isPresent()) {
            return $patient.get();
        }
        throw new ResponseStatusException(NOT_FOUND, "Unable to find the patient");
    }

    @GetMapping("/patients/department/{department}")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getPatientsByAdmittingDepartment(@PathVariable(name = "department") String doctorsDepartment) {
        String upperCaseDepartment = doctorsDepartment.toUpperCase();
        try {
            Department departmentEnum = Department.valueOf(upperCaseDepartment);
            return patientRepository.findPatientsByAdmittingDepartment(departmentEnum);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(BAD_REQUEST, "Unable to find this department");
        }
    }

    @GetMapping("/patients/doctor/off")
    public List<Patient> getPatientsByDoctorOff() {
        return patientRepository.findPatientsByOffDoctor();
    }

    @GetMapping("/patients/birthdate/birth-range")
    public List<Patient> getPatientsByBirthDateRange(
        @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
        @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
            return patientRepository.findPatientsByBirthDateRange(startDate, endDate);
        }

}