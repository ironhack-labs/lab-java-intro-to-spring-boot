package org.example.springbootlab.controller;
import org.example.springbootlab.entity.Employee;
import org.example.springbootlab.entity.Patient;
import org.example.springbootlab.enums.EmployeeStatus;
import org.example.springbootlab.repository.InMemoryEmployeeDb;
import org.example.springbootlab.repository.InMemoryPatientDb;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final InMemoryPatientDb db;
    private final InMemoryEmployeeDb employeeDb;

    public PatientController(InMemoryPatientDb db, InMemoryEmployeeDb employeeDb) {
        this.db = db;
        this.employeeDb = employeeDb;
    }

    @GetMapping
    public List<Patient> getAllPatients() {
        return new ArrayList<>(db.patients.values());
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Integer id) {
        return db.patients.get(id);
    }

    @GetMapping("/birthRange")
    public List<Patient> getPatientsByDobRange(@RequestParam String start,
                                               @RequestParam String end) {

        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);

        List<Patient> result = new ArrayList<>();

        for (Patient p : db.patients.values()) {
            if ((p.getDate_of_birth().isEqual(startDate) || p.getDate_of_birth().isAfter(startDate)) &&
                    (p.getDate_of_birth().isEqual(endDate) || p.getDate_of_birth().isBefore(endDate))) {
                result.add(p);
            }
        }
        return result;
    }

    @GetMapping("/admitting-department/{department}")
    public List<Patient> getPatientsByDoctorDepartment(@PathVariable String department) {

        List<Patient> result = new ArrayList<>();

        for (Patient p : db.patients.values()) {
            Employee doctor = employeeDb.employees.get(p.getAdmitted_by());
            if (doctor != null && doctor.getDepartment().equalsIgnoreCase(department)) {
                result.add(p);
            }
        }
        return result;
    }

    @GetMapping("/doctor-status/{status}")
    public List<Patient> getPatientsByDoctorStatus(@PathVariable String status) {

        List<Patient> result = new ArrayList<>();
        EmployeeStatus st = EmployeeStatus.valueOf(status.toUpperCase());

        for (Patient p : db.patients.values()) {
            Employee doctor = employeeDb.employees.get(p.getAdmitted_by());
            if (doctor != null && doctor.getStatus() == st) {
                result.add(p);
            }
        }
        return result;
    }

    @GetMapping("/doctor-off")
    public List<Patient> getPatientsWithDoctorOff() {

        List<Patient> result = new ArrayList<>();

        for (Patient p : db.patients.values()) {
            Employee doctor = employeeDb.employees.get(p.getAdmitted_by());
            if (doctor != null && doctor.getStatus() == EmployeeStatus.OFF) {
                result.add(p);
            }
        }
        return result;
    }
}
