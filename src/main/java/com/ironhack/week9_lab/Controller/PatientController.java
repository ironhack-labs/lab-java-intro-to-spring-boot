package com.ironhack.week9_lab.Controller;

import com.ironhack.week9_lab.Services.PatientService;
import com.ironhack.week9_lab.enums.Status;
import com.ironhack.week9_lab.model.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {
    final private PatientService patientService;

    @GetMapping
    public List<Patient> getAllPatients(){
        return  patientService.getAllPatients();
    }

    @GetMapping("/id/{id}")
    public Optional<Patient> getPatientById(@PathVariable Long id){
        return patientService.getPatientById(id);
    }

    @GetMapping("/date-of-birth")
    public List<Patient> getPatientByDOB( @RequestParam("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
                                              @RequestParam("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to){
        return patientService.getPatientByDatOfBirthRange(from,to);
    }

    @GetMapping("/doctor/{doctor}")
    public List<Patient> getPatientByAdmittingDocDept(@PathVariable String department){
        return patientService.getPatientsByAdmittingDoctorDepartment(department);
    }

    @GetMapping("/status/{status}")
    public List<Patient> getPatientByDocStatus(@PathVariable String status){
        Status docStatus= Status.valueOf(status.toUpperCase());
        return patientService.getPatientsByDoctorStatus(docStatus);
    }



}
