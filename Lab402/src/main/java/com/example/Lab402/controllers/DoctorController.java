package com.example.Lab402.controllers;


import com.example.Lab402.enums.EmployeeStatus;
import com.example.Lab402.models.Doctor;
import com.example.Lab402.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DoctorController {
    @Autowired
    private DoctorRepository doctorRepository;


    @GetMapping("/doctors/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Doctor findById(@PathVariable String id) {
        return doctorRepository.findById(id).get();
    }

    @GetMapping("/doctors")
    @ResponseStatus(HttpStatus.OK)
    public List<Doctor> combinedSearch(@RequestParam Optional<String> department, @RequestParam Optional<EmployeeStatus> status) {
        if (department.isPresent() && status.isPresent()) {
            return doctorRepository.findByDepartmentAndStatus(department.get(), status.get());
        } else if (department.isPresent()) {
            return doctorRepository.findByDepartment(department.get());
        } else {
            return doctorRepository.findAll();
        }
    }
}
