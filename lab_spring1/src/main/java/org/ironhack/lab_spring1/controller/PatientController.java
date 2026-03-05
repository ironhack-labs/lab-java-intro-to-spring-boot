package org.ironhack.lab_spring1.controller;

import org.ironhack.lab_spring1.entity.Employee;
import org.ironhack.lab_spring1.entity.Patient;
import org.ironhack.lab_spring1.repository.EmployeeRepo;
import org.ironhack.lab_spring1.repository.PatientRepo;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static org.ironhack.lab_spring1.enums.EmployeeStatus.OFF;

@RestController
@RequestMapping("/aboutPatient")
public class PatientController {

    private final PatientRepo patientRepo;
    private final EmployeeRepo employeeRepo;

    public PatientController(PatientRepo patientRepo, EmployeeRepo employeeRepo) {
        this.patientRepo = patientRepo;
        this.employeeRepo = employeeRepo;
    }


    @GetMapping
    public List<Patient> getPatients(){
        return new ArrayList<>(patientRepo.patients.values());
    }

    @GetMapping("/{id}")
    public Patient getPatient(@PathVariable int id){
        return patientRepo.patients.get(id);
    }

    @GetMapping("/birth_date")
    public List<Patient> getBirthDates(@RequestParam String start, @RequestParam String end){
        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);
        List<Patient> patients = new ArrayList<>();
        for(Patient patient : patientRepo.patients.values()){
            if(patient.getDateOfBirth().isEqual(startDate) || patient.getDateOfBirth().isAfter(startDate)&&
                    (patient.getDateOfBirth().isEqual(endDate) || patient.getDateOfBirth().isBefore(endDate))) {
                patients.add(patient);
            }
        }
        return patients;
    }

    @GetMapping("/department/{department}")
    public List<Patient> getPatientsByDepartment(@PathVariable String department){
        List<Patient> patients = new ArrayList<>();
       for(Employee employee: employeeRepo.employees.values()){
           for(Patient patient : patientRepo.patients.values()){
               if (employee.getId()==patient.getAdmittedBy() && employee.getDepartment().equals(department)){
                   patients.add(patient);
               }
           }

       }
       return patients;
    }


    @GetMapping("status/OFF")
    public List<Patient> getPatientsByStatus(){
        List<Patient> patients = new ArrayList<>();
        for(Employee employee: employeeRepo.employees.values()){
            for(Patient patient : patientRepo.patients.values()){
                if (employee.getId()==patient.getAdmittedBy() && employee.getStatus()==OFF){
                    patients.add(patient);
                }
            }
        }
        return patients;
    }

}