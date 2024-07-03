package com.labs.lab_intro_to_spring_boot.controller.interfaces;

import com.labs.lab_intro_to_spring_boot.model.Patient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

public interface IPatientController {
    List<Patient> getAllPatients();
    Patient getPatientById(Long patientId);
    List<Patient> getPatientsByDoctorDepartment(@RequestParam String department);
    List<Patient> getPatientsByDateOfBirthRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate);
    List<Patient> getPatientsByDoctorStatus(@RequestParam String status);
}
