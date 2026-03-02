package org.example.springlab.module;

import org.example.springlab.module.Employee;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Component
public class DataDemo {
    public Map<Integer, Employee> employees = new HashMap<>();
    public Map<Integer, Patient> patients = new HashMap<>();
    public DataDemo(){
        employees.put(356712, new Employee(356712, "cardiology", "Alonso Flores", "ON_CALL"));
        employees.put(564134, new Employee(564134, "immunology", "Sam Ortega", "ON"));
        employees.put(761527, new Employee(761527, "cardiology", "German Ruiz", "OFF"));
        employees.put(166552, new Employee(166552, "pulmonary", "Maria Lin", "ON"));
        employees.put(156545, new Employee(156545, "orthopaedic", "Paolo Rodriguez", "ON_CALL"));
        employees.put(172456, new Employee(172456, "psychiatric", "John Paul Armes", "OFF"));


        patients.put(1, new Patient(1, "Jaime Jordan", LocalDate.of(1984, 3, 2), 564134));
        patients.put(2, new Patient(2, "Marian Garcia", LocalDate.of(1972, 1, 12), 564134));
        patients.put(3, new Patient(3, "Julia Dusterdieck", LocalDate.of(1954, 6, 11), 356712));
        patients.put(4, new Patient(4, "Steve McDuck", LocalDate.of(1931, 11, 10), 761527));
        patients.put(5, new Patient(5, "Marian Garcia", LocalDate.of(1999, 2, 15), 172456));
    }

}
