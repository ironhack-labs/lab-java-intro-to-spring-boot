package com.ironhack.controller.impl;
import com.ironhack.controller.interfaces.IPatientController;
import com.ironhack.model.Patient;
import com.ironhack.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PatientController implements IPatientController {
    @Autowired
    PatientRepository patientRepository;

    @GetMapping("/patients")
    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }

    @GetMapping("/patients/{id}")
    public Patient getPatientById(@PathVariable Integer id){
        Optional<Patient> patientOptional = patientRepository.findById(id);
        return patientOptional.orElse(null);
    }

    @GetMapping("/patients/date_of_birth/{start_date}/{end_date}")
    public List<Patient> getAllPatientsByDateOfBirthRange( @PathVariable LocalDate start_date, @PathVariable LocalDate end_date) {
        return patientRepository.findAllByDateOfBirthBetween(start_date, end_date);
    }

    @GetMapping("/patients/admitting_doctor/department/{department}")
    public List<Patient> getAllPatientsByAdmittingDoctorDepartment(@PathVariable String department){
        return patientRepository.findAllByAdmittedBy_Department(department);
    }

    @GetMapping("/patients/admitting_doctor/status/off")
    public List<Patient> getAllPatientsByAdmittingDoctorStatusOff(){
        return patientRepository.findAllByAdmittedBy_Status("OFF");
    }
}


