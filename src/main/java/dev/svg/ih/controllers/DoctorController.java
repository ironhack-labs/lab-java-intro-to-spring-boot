package dev.svg.ih.controllers;

import dev.svg.ih.model.Doctor;
import dev.svg.ih.model.Patient;
import dev.svg.ih.services.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/doctors/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Doctor> getDoctorsById(@PathVariable("id") Long id) {
        return doctorService.getDoctorsById(id);
    }

    @GetMapping("/doctors")
    @ResponseStatus(HttpStatus.OK)
    public List<Doctor> getDoctors(@RequestParam Optional<String> status, @RequestParam Optional<String> department) {
        if (status.isPresent() && department.isPresent()) {
            return doctorService.getDoctorsByStatusAndDepartment(status.get(), department.get());
        } else if (status.isPresent()) {
            return doctorService.getDoctorsByStatus(status.get());
        } else if (department.isPresent()) {
            return doctorService.getDoctorsByDepartment(department.get());
        } else {
            return doctorService.getAllDoctors();
        }
    }

    @GetMapping("/patients/doctorstatusoff")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getPatientsWithDoctorHavingStatusOff() {
        return doctorService.getPatientsWithDoctorHavingStatusOff();
    }

}
