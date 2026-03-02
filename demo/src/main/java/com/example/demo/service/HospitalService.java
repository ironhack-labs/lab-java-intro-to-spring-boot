package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.model.Patient;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * In-memory hospital data service.
 * Provides CRUD-like operations for employees and patients.
 */
@Service
public class HospitalService {

    private final Map<Long, Employee> employeeMap = new HashMap<>();
    private final Map<Long, Patient> patientMap = new HashMap<>();

    public HospitalService() {
        // Sample data - employees
        addEmployee(new Employee(356712L, "cardiology", "Alonso Flores", "ON_CALL"));
        addEmployee(new Employee(564134L, "immunology", "Sam Ortega", "ON"));
        addEmployee(new Employee(761527L, "cardiology", "German Ruiz", "OFF"));
        addEmployee(new Employee(166552L, "pulmonary", "Maria Lin", "ON"));
        addEmployee(new Employee(156545L, "orthopaedic", "Paolo Rodriguez", "ON_CALL"));
        addEmployee(new Employee(172456L, "psychiatric", "John Paul Armes", "OFF"));

        // Sample data - patients
        addPatient(new Patient(1L, "Jaime Jordan", LocalDate.parse("1984-03-02"), 564134L));
        addPatient(new Patient(2L, "Marian Garcia", LocalDate.parse("1972-01-12"), 564134L));
        addPatient(new Patient(3L, "Julia Dusterdieck", LocalDate.parse("1954-06-11"), 356712L));
        addPatient(new Patient(4L, "Steve McDuck", LocalDate.parse("1931-11-10"), 761527L));
        addPatient(new Patient(5L, "Marian Garcia", LocalDate.parse("1999-02-15"), 172456L));
    }

    // --- Employee methods ---

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employeeMap.values());
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return Optional.ofNullable(employeeMap.get(id));
    }

    public List<Employee> getEmployeesByStatus(String status) {
        return employeeMap.values().stream()
                .filter(e -> e.getStatus().equalsIgnoreCase(status))
                .collect(Collectors.toList());
    }

    public List<Employee> getEmployeesByDepartment(String department) {
        return employeeMap.values().stream()
                .filter(e -> e.getDepartment().equalsIgnoreCase(department))
                .collect(Collectors.toList());
    }

    public Employee addEmployee(Employee employee) {
        employeeMap.put(employee.getEmployeeId(), employee);
        return employee;
    }

    // --- Patient methods ---

    public List<Patient> getAllPatients() {
        return new ArrayList<>(patientMap.values());
    }

    public Optional<Patient> getPatientById(Long id) {
        return Optional.ofNullable(patientMap.get(id));
    }

    public List<Patient> getPatientsByDateRange(LocalDate start, LocalDate end) {
        return patientMap.values().stream()
                .filter(p -> !p.getDateOfBirth().isBefore(start) && !p.getDateOfBirth().isAfter(end))
                .collect(Collectors.toList());
    }

    public List<Patient> getPatientsByDoctorDepartment(String department) {
        Set<Long> doctorIds = getEmployeesByDepartment(department).stream()
                .map(Employee::getEmployeeId)
                .collect(Collectors.toSet());

        return patientMap.values().stream()
                .filter(p -> doctorIds.contains(p.getAdmittedBy()))
                .collect(Collectors.toList());
    }

    public List<Patient> getPatientsByDoctorStatus(String status) {
        Set<Long> doctorIds = getEmployeesByStatus(status).stream()
                .map(Employee::getEmployeeId)
                .collect(Collectors.toSet());

        return patientMap.values().stream()
                .filter(p -> doctorIds.contains(p.getAdmittedBy()))
                .collect(Collectors.toList());
    }

    public Patient addPatient(Patient patient) {
        patientMap.put(patient.getPatientId(), patient);
        return patient;
    }
}