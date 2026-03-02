package com.example.demo.Controller;

import com.example.demo.Employee;
import com.example.demo.Patient;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;

@RestController
public class HospitalController {




    @GetMapping("/api/doctors/all")
    public Collection<Employee> getAllDoctors(){

        return DataStore.employees.values();
    }
    @GetMapping("/api/doctors/{id}")
    public Employee getDoctorById(@PathVariable int id){
        Employee e=DataStore.employees.get(id);
        return e;
    }
    @GetMapping("/api/doctors/{status}")
    public Collection<Employee> getDoctorByStatus(@PathVariable String status){
        Collection<Employee> employees= DataStore.employees.values()
                .stream()
                .filter(e->e.getStatus().equalsIgnoreCase(status)).toList();
        return employees;
    }
    @GetMapping("api/doctors/{department}")
    public Collection<Employee> getDoctorByDepartment(@PathVariable String department){
        Collection<Employee> employees=DataStore.employees.values()
                .stream()
                .filter(e->e.getDepartment().equalsIgnoreCase(department)).toList();
        return employees;
    }
    @GetMapping("api/patients/all")
    public Collection<Patient> getAllPatients(){
        return DataStore.patients.values();
    }
    @GetMapping("api/patiens/{id}")
    public Patient getPatientById(@PathVariable int id){
        Patient p=DataStore.patients.get(id);
        return p;
    }
    @GetMapping("/api/patients/dob")
    public Collection<Patient> getPatientsByDateOfBirthRange(@RequestParam @DateTimeFormat(pattern="yyyy-mm-dd") Date fromDate,
                                                     @RequestParam @DateTimeFormat(pattern="yyyy-mm-dd") Date toDate) {
        return DataStore.patients.values().stream()
                .filter(p -> {
                    Date dob = p.getDate_of_birth();
                    return !dob.before(fromDate) && !dob.after(toDate);
                })
                .toList();
    }
    @GetMapping("/api/patients/department/{department}")
    public Collection<Patient> getPatientsByDoctorDepartment(@PathVariable String department) {
        return DataStore.patients.values().stream()
                .filter(p -> p.getAdmitted_by().getDepartment().equalsIgnoreCase(department))
                .toList();
    }
    @GetMapping("/api/patients/doctor/off")
    public Collection<Patient> getPatientsWithDoctorOff() {
        return DataStore.patients.values().stream()
                .filter(p -> p.getAdmitted_by().getStatus().equalsIgnoreCase("OFF"))
                .toList();
    }


}
