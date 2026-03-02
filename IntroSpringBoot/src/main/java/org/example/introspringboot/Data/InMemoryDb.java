package org.example.introspringboot.Data;

import org.example.introspringboot.model.Employee;
import org.example.introspringboot.model.Patient;
import org.example.introspringboot.model.Status;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class InMemoryDb {

    private final Map<Integer, Employee> employees = new HashMap<>();
    private final Map<Integer, Patient> patients = new HashMap<>();

    public InMemoryDb() {
        seedEmployees();
        seedPatients();
    }

    private void seedEmployees() {
        employees.put(356712, new Employee(356712, "cardiology", "Alonso Flores", Status.ON_CALL));
        employees.put(564134, new Employee(564134, "immunology", "Sam Ortega", Status.ON));
        employees.put(761527, new Employee(761527, "cardiology", "German Ruiz", Status.OFF));
        employees.put(166552, new Employee(166552, "pulmonary", "Maria Lin", Status.ON));
        employees.put(156545, new Employee(156545, "orthopaedic", "Paolo Rodriguez", Status.ON_CALL));
        employees.put(172456, new Employee(172456, "psychiatric", "John Paul Armes", Status.OFF));
    }

    private void seedPatients() {
        patients.put(1, new Patient(1, "Jaime Jordan", LocalDate.parse("1984-03-02"), 564134));
        patients.put(2, new Patient(2, "Marian Garcia", LocalDate.parse("1972-01-12"), 564134));
        patients.put(3, new Patient(3, "Julia Dusterdieck", LocalDate.parse("1954-06-11"), 356712));
        patients.put(4, new Patient(4, "Steve McDuck", LocalDate.parse("1931-11-10"), 761527));
        patients.put(5, new Patient(5, "Marian Garcia", LocalDate.parse("1999-02-15"), 172456));
    }

    public Collection<Employee> getAllEmployees() {
        return employees.values();
    }

    public Collection<Patient> getAllPatients() {
        return patients.values();
    }

    public Employee getEmployeeById(int id) {
        return employees.get(id);
    }

    public Patient getPatientById(int id) {
        return patients.get(id);
    }
}
