package org.example.springlab1.repository;

import org.example.springlab1.model.Employee;
import org.example.springlab1.model.Patient;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class MockDataStore {
    private final Map<Long, Employee> employees=new HashMap<>();
    private final Map<Long, Patient> patients=new HashMap<>();

    public MockDataStore(){
        addEmployee(new Employee(356712L, "cardiology", "Alonso Flores", "ON_CALL"));
        addEmployee(new Employee(564134L, "immunology", "Sam Ortega", "ON"));
        addEmployee(new Employee(761527L, "cardiology", "German Ruiz", "OFF"));
        addEmployee(new Employee(166552L, "pulmonary", "Maria Lin", "ON"));
        addEmployee(new Employee(156545L, "orthopaedic", "Paolo Rodriguez", "ON_CALL"));
        addEmployee(new Employee(172456L, "psychiatric", "John Paul Armes", "OFF"));
        addPatient(new Patient(1L, "Jaime Jordan", LocalDate.of(1984, 3, 2), 564134L));
        addPatient(new Patient(2L, "Marian Garcia", LocalDate.of(1972, 1, 12), 564134L));
        addPatient(new Patient(3L, "Julia Dusterdieck", LocalDate.of(1954, 6, 11), 356712L));
        addPatient(new Patient(4L, "Steve McDuck", LocalDate.of(1931, 11, 10), 761527L));
        addPatient(new Patient(5L, "Marian Garcia", LocalDate.of(1999, 2, 15), 172456L));


    }
    public Map<Long, Employee> getEmployees() {
        return employees;
    }

    public Map<Long, Patient> getPatients() {
        return patients;
    }
    public void addPatient(Patient p) { patients.put(p.getPatientId(), p); }
    public void addEmployee(Employee emp) { employees.put(emp.getEmployeeId(), emp); }
}
