package com.ironhack.demo.controller;

import com.ironhack.demo.model.Employee;
import com.ironhack.demo.model.Patient;
import com.ironhack.demo.repository.EmployeeRepository;
import com.ironhack.demo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class PatientController {

   @Autowired
   private PatientRepository patientRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/patients")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getPatients() {
        return patientRepository.findAll();
    }

    @GetMapping("/patients/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Patient getPatientById(@PathVariable(name="id") Integer patientID) {
        return patientRepository.findById(patientID).get();
    }
    @GetMapping("/patients/date_of_birth_range")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getByBirthdateRange(@RequestParam String startDate, @RequestParam String endDate) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parsedStartDate = dateFormat.parse(startDate);
        Date parsedEndDate = dateFormat.parse(endDate);
        return patientRepository.findByDateOfBirthBetween(parsedStartDate, parsedEndDate);
    }

    @GetMapping("/patients/department/{department}")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getPatientsByAdmittingDoctorDepartment(@PathVariable(name="department") String department) {
        return patientRepository.findByDepartment(department);
    }

    @GetMapping("/patients/status/off")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getPatientsByStatusIsOff() {
        return patientRepository.findByStatusIsOff();
    }
}

