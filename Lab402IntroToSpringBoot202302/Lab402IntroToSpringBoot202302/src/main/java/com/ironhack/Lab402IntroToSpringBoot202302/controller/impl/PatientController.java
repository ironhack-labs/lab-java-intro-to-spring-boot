package com.ironhack.Lab402IntroToSpringBoot202302.controller.impl;

import com.ironhack.Lab402IntroToSpringBoot202302.controller.interfaces.IPatientController;
import com.ironhack.Lab402IntroToSpringBoot202302.model.EmployeeStatus;
import com.ironhack.Lab402IntroToSpringBoot202302.model.Patient;
import com.ironhack.Lab402IntroToSpringBoot202302.reporitory.PatientRepository;
import com.ironhack.Lab402IntroToSpringBoot202302.service.interfaces.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PatientController implements IPatientController {
    // Manage queries about DataBase
    // Requests
    //GET PUT DELETE PATH PATCH
    @Autowired
    private final IPatientService patientService;
    //final private = is only assigned once, in the constructor, and never changes.
    // It makes your code safer, clearer and easier to maintain.
    // It is the best recommended practice in Spring Boot for controllers and services.


    public PatientController(IPatientService patientService) {

        this.patientService = patientService;
    }

    //  ****************************************************  GET  ****************************************************
    @GetMapping("/patient")
    public List<Patient> getAllPatient() {

        return patientService.getAllPatient();
    }

    @GetMapping("/patient/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }

    @GetMapping("/patients/dob")
    public List<Patient> getPatientsByDateOfBirthRange(
            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date start,
            @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date end) {
        return patientService.findPatientsByDateOfBirthRange(start, end);

    }

    @GetMapping("/patients/doctor-department/{department}")
    public List<Patient> getPatientByDoctorDepartment(@PathVariable String department) {
        return patientService.findByEmployeeId_Department(department);
    }

    @GetMapping("/patients/doctor-status/{status}")
    public List<Patient> getPatientsByDoctorStatus(@PathVariable EmployeeStatus status) {

         return patientService.findByEmployeeId_Status(status);
    }



    //  ***************************************************  POST  ****************************************************
    @PostMapping("/patient")
    public Patient savePatient(@RequestBody Patient patient) {
        return patientService.savePatient(patient);
    }


}
