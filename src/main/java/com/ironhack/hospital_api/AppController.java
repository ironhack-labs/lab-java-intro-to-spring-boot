package com.ironhack.hospital_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AppController {
    private List<Employee> employees = new ArrayList<>(Arrays.asList(
            new Employee(356712, "cardiology", "Alonso Flores", "ON_CALL"),
            new Employee(564134, "immunology", "Sam Ortega", "ON"),
            new Employee(761527, "cardiology", "German Ruiz", "OFF"),
            new Employee(166552, "pulmonary", "Maria Lin", "ON"),
            new Employee(156545, "orthopaedic", "Paolo Rodriguez", "ON_CALL"),
            new Employee(172456, "psychiatric", "John Paul Armes", "OFF")
    ));
    private List<Patient> patients = new ArrayList<>(Arrays.asList(
            new Patient(1, "Jaime Jordan", "1984-03-02", 564134),
            new Patient(2, "Marian Garcia", "1972-01-12", 564134),
            new Patient(3, "Julia Dusterdieck", "1954-06-11", 356712),
            new Patient(4, "Steve McDuck", "1931-11-10", 761527),
            new Patient(5, "Marian Garcia", "1999-02-15", 172456)
    ));
    @GetMapping("api/doctors")
    public List<Employee> getDoctors() {
        return employees;
    }
    @GetMapping("api/doctors/{id}")
    public Employee getDoctor(@PathVariable int id) {
        return employees.stream().filter(e -> e.getEmployeeId() == id).findFirst().orElse(null);
    }
    @GetMapping("api/doctors/status/{status}")
    public List<Employee> getDoctorStatus(@PathVariable String status) {
        return employees.stream().filter(e -> e.getStatus().equalsIgnoreCase(status)).toList();
    }
    @GetMapping("api/doctor/department/{department}")
    public List<Employee> getDoctorDepartment(@PathVariable String department) {
        return employees.stream().filter(e -> e.getDepartment().equalsIgnoreCase(department)).toList();
    }
    @GetMapping("api/patients")
    public List<Patient> getPatients() {
        return patients;
    }
    @GetMapping("api/patients/{id}")
    public Patient getPatient(@PathVariable int id) {
        return patients.stream().filter(p -> p.getPatientId() == id).findFirst().orElse(null);
    }
    @GetMapping("api/patients/dob")
    public List<Patient> getPatientsByDobRange(@RequestParam String start, @RequestParam String end) {
        return patients.stream()
                .filter(p -> p.getDateOfBirth().compareTo(start) >= 0 &&
                        p.getDateOfBirth().compareTo(end) <= 0)
                .collect(Collectors.toList());
    }
    @GetMapping("/api/patients/department/{department}")
    public List<Patient> getPatientsByDoctorDepartment(@PathVariable String department) {
        List<Integer> doctorIds = employees.stream()
                .filter(e -> e.getDepartment().equalsIgnoreCase(department))
                .map(Employee::getEmployeeId)
                .collect(Collectors.toList());

        return patients.stream()
                .filter(p -> doctorIds.contains(p.getAdmittedBy()))
                .collect(Collectors.toList());
    }

    @GetMapping("/api/patients/doctor/off")
    public Collection<Patient> getPatientsWithDoctorOff() {
        List<Integer> offDoctorIds = employees.stream()
                .filter(e -> e.getStatus().equalsIgnoreCase("OFF"))
                .map(Employee::getEmployeeId)
                .collect(Collectors.toList());

        return patients.stream()
                .filter(p -> offDoctorIds.contains(p.getAdmittedBy()))
                .collect(Collectors.toList());
    }
}

