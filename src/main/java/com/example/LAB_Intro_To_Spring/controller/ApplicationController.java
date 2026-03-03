package com.example.LAB_Intro_To_Spring.controller;

import com.example.LAB_Intro_To_Spring.model.Employee;
import com.example.LAB_Intro_To_Spring.model.Patient;
import com.example.LAB_Intro_To_Spring.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hospital")
public class ApplicationController {
    @Autowired
    private HospitalService hospitalService;

    @GetMapping("/doctors")
    public List<Employee> getAllDoctors(){
        return hospitalService.getAllEmployees();
    }
    @GetMapping("/doctors/{id}")
    public Employee getDoctorById(@PathVariable int id){
        return hospitalService.getEmployeeById(id);
    }
    @GetMapping("/doctors/status/{status}")
    public List<Employee> getDoctorByStatus(@PathVariable String status){
        return hospitalService.getEmployeeByStatus(status);
    }
    @GetMapping("/patients/doctor-department/{dept}")
    public List<Patient> getPatientsByDept(@PathVariable String dept){
        return hospitalService.getAllPatients().stream().filter(p->{
            Employee doc=hospitalService.getEmployeeById(p.getAdmitted_by());
            return doc!=null && doc.getDepartment().equalsIgnoreCase(dept);
        }).toList();
    }
    @GetMapping("/patients")
    public List<Patient> getAllPatients(){
        return hospitalService.getAllPatients();
    }
    @GetMapping("/patients/{id}")
    public Patient getPatientById(@PathVariable int id) {
        return hospitalService.getPatientById(id);
    }
    @GetMapping("/patients/dob")
    public List<Patient> getPatientsByDob(@RequestParam String start, @RequestParam String end) {
        return hospitalService.getPatientsByBirthRange(start, end);
    }
    @GetMapping("/patients/doctor-off")
    public List<Patient> getPatientsByDoctorOff() { return hospitalService.getPatientsWithDoctorOff(); }
 }
