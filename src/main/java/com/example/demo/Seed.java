package com.example.demo;

import com.example.demo.Employees.Employee;
import com.example.demo.Employees.EmployeeStatus;
import com.example.demo.Patients.Patient;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class Seed {

    public static Map<String, Employee> employees = new HashMap<>();
    public static Map<String, Patient> patients = new HashMap<>();

    public static void seed() {

        // ===== Employees (Doctors) =====
        Employee doc1 = new Employee("E1", EmployeeStatus.ON, "Dr. Smith", "Cardiology");
        Employee doc2 = new Employee("E2", EmployeeStatus.ON, "Dr. Adams", "Neurology");
        Employee doc3 = new Employee("E3", EmployeeStatus.OFF, "Dr. Brown", "Cardiology");
        Employee doc4 = new Employee("E4", EmployeeStatus.ON_CALL, "Dr. Taylor", "Orthopedics");

        employees.put(doc1.getId(), doc1);
        employees.put(doc2.getId(), doc2);
        employees.put(doc3.getId(), doc3);
        employees.put(doc4.getId(), doc4);

        // ===== Patients =====
        patients.put("P1", new Patient("P1", "John Doe",
                new GregorianCalendar(1990, Calendar.JANUARY, 10).getTime(), "E1"));

        patients.put("P2", new Patient("P2", "Jane Smith",
                new GregorianCalendar(1985, Calendar.MARCH, 22).getTime(), "E2"));

        patients.put("P3", new Patient("P3", "Michael Johnson",
                new GregorianCalendar(2000, Calendar.JULY, 5).getTime(), "E3"));

        patients.put("P4", new Patient("P4", "Emily Davis",
                new GregorianCalendar(1995, Calendar.DECEMBER, 15).getTime(), "E1"));
    }

}