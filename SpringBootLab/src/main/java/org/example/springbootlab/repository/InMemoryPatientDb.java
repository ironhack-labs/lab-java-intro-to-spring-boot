package org.example.springbootlab.repository;


import org.example.springbootlab.entity.Patient;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Component
public class InMemoryPatientDb {
    public final Map<Integer, Patient> patients = new HashMap<>();

    public InMemoryPatientDb() {
        patients.put(1, new Patient(1, "Jaime Jordan", LocalDate.parse("1984-03-02"), 564134));
        patients.put(2, new Patient(2, "Marian Garcia", LocalDate.parse("1972-01-12"), 564134));
        patients.put(3, new Patient(3, "Julia Dusterdieck", LocalDate.parse("1954-06-11"), 356712));
        patients.put(4, new Patient(4, "Steve McDuck", LocalDate.parse("1931-11-10"), 761527));
        patients.put(5, new Patient(5, "Marian Garcia", LocalDate.parse("1999-02-15"), 172456));

    }
}
