package com.example.lab_java_intro_to_spring_boot.service;

import com.example.lab_java_intro_to_spring_boot.model.Employee;
import com.example.lab_java_intro_to_spring_boot.model.Patient;
import com.example.lab_java_intro_to_spring_boot.model.Status;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static com.example.lab_java_intro_to_spring_boot.model.Status.*;

@Service
public class DataService {
    private Map<Integer, Employee> employees = new HashMap<>();
    private Map<Integer, Patient> patients = new HashMap<>();

    public DataService() {
        employees.put(356712, new Employee(356712, "cardiology", "Alonso Flores", ON_CALL));
        employees.put(564134, new Employee(564134, "immunology", "Sam Ortega", ON));
        employees.put(761527, new Employee(761527, "cardiology", "German Ruiz", OFF));
        employees.put(166552, new Employee(166552, "pulmonary", "Maria Lin", ON));
        employees.put(156545, new Employee(156545, "orthopaedic", "Paolo Rodriguez", ON_CALL));
        employees.put(172456, new Employee(172456, "psychiatric", "John Paul Armes", OFF));

        patients.put(1, new Patient(1, "Jaime Jordan", "1984-03-02", 564134));
        patients.put(2, new Patient(2, "Marian Garcia", "1972-01-12", 564134));
        patients.put(3, new Patient(3, "Julia Dusterdieck", "1954-06-11", 356712));
        patients.put(4, new Patient(4, "Steve McDuck", "1931-11-10", 761527));
        patients.put(5, new Patient(5, "Marian Garcia", "1999-02-15", 172456));
    }

    // --- Employee (Doctor) Methods ---
    public Collection<Employee> getAllEmployees() {
        return employees.values();
    }

    public Employee getEmployeeById(int id) {
        return employees.get(id);
    }

    public Collection<Employee> getEmployeesByStatus(Status status) {
        return employees.values().stream()
                .filter(e -> e.getStatus() == status)
                .collect(Collectors.toList());
    }

    public Collection<Employee> getEmployeesByDepartment(String department) {
        return employees.values().stream()
                .filter(e -> e.getDepartment().equalsIgnoreCase(department))
                .collect(Collectors.toList());
    }

    // --- Patient Methods ---
    public Collection<Patient> getAllPatients() {
        return patients.values();
    }

    public Patient getPatientById(int id) {
        return patients.get(id);
    }

    public Collection<Patient> getPatientsByDateOfBirthRange(String startDate, String endDate) {
        return patients.values().stream()
                .filter(p -> p.getDate_of_birth().compareTo(startDate) >= 0 && p.getDate_of_birth().compareTo(endDate) <= 0)
                .collect(Collectors.toList());
    }

    public Collection<Patient> getPatientsByDoctorDepartment(String department) {
        return patients.values().stream()
                .filter(p -> {
                    Employee doctor = employees.get(p.getAdmitted_by());
                    return doctor != null && doctor.getDepartment().equalsIgnoreCase(department);
                })
                .collect(Collectors.toList());
    }

    public Collection<Patient> getPatientsWithDoctorStatusOff() {
        return patients.values().stream()
                .filter(p -> {
                    Employee doctor = employees.get(p.getAdmitted_by());
                    return doctor != null && doctor.getStatus() == OFF;
                })
                .collect(Collectors.toList());
    }
}