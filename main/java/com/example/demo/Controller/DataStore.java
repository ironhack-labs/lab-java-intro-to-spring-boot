package com.example.demo.Controller;

import com.example.demo.Employee;
import com.example.demo.Patient;


import java.util.*;

public class DataStore {
    public static Map<Integer, Employee> employees=new HashMap<>();
    public static Map<Integer, Patient> patients=new HashMap<>();

    public static void Seed() {

        employees.put(1, new Employee(1, "Cardiology", "ON", "Dr. Alice Smith"));
        employees.put(2, new Employee(2, "Neurology", "OFF", "Dr. Bob Johnson"));
        employees.put(3, new Employee(3, "Emergency", "ON", "Nurse Carol Lee"));

        patients.put(1, new Patient(1, "John Doe", new GregorianCalendar(1980, Calendar.MAY, 20).getTime(), employees.get(1)));
        patients.put(2, new Patient(2, "Jane Roe", new GregorianCalendar(1990, Calendar.JULY, 15).getTime(), employees.get(2)));
        patients.put(3, new Patient(3, "Mark Brown", new GregorianCalendar(1965, Calendar.DECEMBER, 1).getTime(), employees.get(3)));
    }
}
