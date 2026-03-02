package com.ironhack;

import java.util.HashMap;
import java.util.Map;

public class PatientRepository {
    static final Map<Integer, Patient> patients = new HashMap<>();

    static { //niye idk
        patients.put(1, new Patient(1, "Jaime Jordan", "1984-03-02", 564134));
        patients.put(2, new Patient(2, "Marian Garcia", "1972-01-12", 564134));
        patients.put(3, new Patient(3, "Julia Dusterdieck", "1954-06-11", 356712));
        patients.put(4, new Patient(4, "Steve McDuck", "1931-11-10", 761527));
        patients.put(5, new Patient(5, "Marian Garcia", "1999-02-15", 172456));
    }
}
