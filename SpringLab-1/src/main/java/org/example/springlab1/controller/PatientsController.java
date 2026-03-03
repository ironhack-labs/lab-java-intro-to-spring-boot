package org.example.springlab1.controller;

import org.example.springlab1.model.Employee;
import org.example.springlab1.model.Patient;
import org.example.springlab1.repository.MockDataStore;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/patiens")
public class PatientsController {

    public MockDataStore dataStore;
    public PatientsController(MockDataStore dataStore){
        this.dataStore=dataStore;
    }

    @GetMapping
    public List<Patient> getAllPatients(){
        return dataStore.getPatients().values().stream().collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id){
        return dataStore.getPatients().get(id);
    }

    @GetMapping("/dob")
    public List<Patient> getPatientsByDobRange(@RequestParam LocalDate start, @RequestParam LocalDate end){
        return dataStore.getPatients().values().stream().filter(p -> !p.getDateOfBirth().isBefore(start)
                && !p.getDateOfBirth().isAfter(end)).collect(Collectors.toList());

    }

    @GetMapping("/department/{department}")
    public List<Patient> getPatientsByDoctorDepartment(@PathVariable String department) {

        return dataStore.getPatients()
                .values()
                .stream().filter(p -> {
                    Employee doctor = dataStore.getEmployees().get(p.getAdmittedBy());
                    return doctor != null && doctor.getDepartment().equalsIgnoreCase(department);
                }).collect(Collectors.toList());
    }

    @GetMapping("/doctor-status/{status}")
    public List<Patient> getPatientsByDoctorStatus(@PathVariable String status) {

        return dataStore.getPatients()
                .values().stream().filter(p -> {
                    Employee doctor = dataStore.getEmployees().get(p.getAdmittedBy());
                    return doctor != null &&
                            doctor.getStatus().equalsIgnoreCase(status);
                }).collect(Collectors.toList());
    }


}
