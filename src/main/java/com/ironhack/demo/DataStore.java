package com.ironhack.demo;

import java.time.LocalDate;
import java.util.HashMap;

public class DataStore {
    public static final HashMap<Long, Doctors> doctors = new HashMap<Long, Doctors>();
    public static final HashMap<Long, Patient> patients = new HashMap<Long, Patient>();

    static {
        doctors.put(356712L,
                new Doctors(356712L, "cardiology", "Alonso Flores", Status.ON_CALL));

        doctors.put(564134L,
                new Doctors(564134L, "immunology", "Sam Ortega", Status.ON));

        doctors.put(761527L,
                new Doctors(761527L, "cardiology", "German Ruiz", Status.OFF));

        doctors.put(166552L,
                new Doctors(166552L, "pulmonary", "Maria Lin", Status.ON));

        doctors.put(156545L,
                new Doctors(156545L, "orthopaedic", "Paolo Rodriguez", Status.ON_CALL));

        doctors.put(172456L,
                new Doctors(172456L, "psychiatric", "John Paul Armes", Status.OFF));

        patients.put(1L,
                new Patient(1L, "Jaime Jordan",
                        LocalDate.parse("1984-03-02"), 564134L));

        patients.put(2L,
                new Patient(2L, "Marian Garcia",
                        LocalDate.parse("1972-01-12"), 564134L));

        patients.put(3L,
                new Patient(3L, "Julia Dusterdeck",
                        LocalDate.parse("1954-06-11"), 356712L));

        patients.put(4L,
                new Patient(4L, "Steve McDuck",
                        LocalDate.parse("1931-11-10"), 761527L));

        patients.put(5L,
                new Patient(5L, "Marian Garcia",
                        LocalDate.parse("1999-02-15"), 172456L));


    }

}