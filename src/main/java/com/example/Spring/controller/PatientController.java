package com.example.Spring.controller;

import com.example.Spring.EmployeeStatus;
import com.example.Spring.model.Employee;
import com.example.Spring.model.Patient;
import com.example.Spring.service.EmployeeService;
import com.example.Spring.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/patient")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getPatients(@RequestParam Optional<EmployeeStatus> status,@RequestParam Optional<String> department) {
        if (status.isPresent()) {
            return patientService.getPatienByDoctorStatus(status);
        } else if(department.isPresent()){
            return patientService.getPatientByDoctorDepartment(department);
        }else {
            return patientService.getAllPatients();
        }
    }

    @GetMapping("/patient/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Patient> getPatientByID(@PathVariable(name="id") int patientId) {
        return patientService.getPatientId(patientId);
    }

    @GetMapping("/patient/Date/{initDate}/{endDate}")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getPatientByRangeOfDate(@PathVariable(name="initDate")@DateTimeFormat(pattern="yyyy-MM-dd") Date initDate, @PathVariable(name="endDate")@DateTimeFormat(pattern="yyyy-MM-dd") Date endDate) {
        return patientService.getPatientRangeDate(initDate,endDate);
    }
}
