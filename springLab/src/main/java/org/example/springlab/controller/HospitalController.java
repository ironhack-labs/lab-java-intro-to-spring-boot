package org.example.springlab.controller;

import org.example.springlab.module.DataDemo;
import org.example.springlab.module.Employee;
import org.example.springlab.module.Patient;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HospitalController {
    private DataDemo data;

    public HospitalController(DataDemo data) {
        this.data = data;
    }

    @GetMapping("/doctors")
    public Collection<Employee> getDoctors(){
           return data.employees.values();
    }

    @GetMapping("/doctor/{id}")
    public Employee getDoctorsByID(@PathVariable int id){
        return data.employees.get(id);
    }

    @GetMapping("/doctors/{status}")
    public Collection<Employee> getDoctorsByStatus(@PathVariable String status){
        List<Employee> doctorsList = new ArrayList<>();
        for(Employee employee : data.employees.values()){
            if (employee.getStatus().equalsIgnoreCase(status)){
                doctorsList.add(employee);
            }
        }
        return doctorsList;
    }

    @GetMapping("/doctors/{department}")
    public Collection<Employee> getDoctorsByDepartment(@PathVariable String department){
        List<Employee> doctorsList = new ArrayList<>();
        for(Employee employee : data.employees.values()){
            if (employee.getStatus().equalsIgnoreCase(department)){
                doctorsList.add(employee);
            }
        }
        return doctorsList;
    }

    @GetMapping("/patients")
    public Collection<Patient> getPatients(){
        return data.patients.values();
    }

    @GetMapping("/patient/{id}")
    public Patient getPatientsByID(@PathVariable int id){
        return data.patients.get(id);
    }

    @GetMapping("patients/{start}/{end}")
    public Collection<Patient> getPatientsByDate(@PathVariable LocalDate start,@PathVariable LocalDate end){
        List<Patient> patientList = new ArrayList<>();
        for (Patient p : data.patients.values()){
            if (p.getDateOfBirth().isAfter(start) && p.getDateOfBirth().isBefore(end)){
                patientList.add(p);
            }
        }
        return patientList;
    }
    @GetMapping("/patients/department/{department}")
    public Collection<Patient> getPatientsByDepartment(@PathVariable String department){
        List<Patient> patientsList = new ArrayList<>();

        for (Patient p : data.patients.values()){
            Employee doctor = data.employees.get(p.getAdmittedBy());
            if (doctor.getDepartment().equalsIgnoreCase(department)){
                patientsList.add(p);
            }
        }
        return patientsList;
    }

    @GetMapping("/patients/doctor-status/OFF")
    public Collection<Patient> getPatientsByDoctorStatusOFF(){
        List<Patient> patientList = new ArrayList<>();
        for (Patient p : data.patients.values()){
            Employee doctor = data.employees.get(p.getAdmittedBy());
            if (doctor.getStatus().equals("OFF")){
                patientList.add(p);
            }
        }
        return patientList;
    }
}
