package com.ironhack;

import java.util.HashMap;
import java.util.Map;

public class EmployeeRepository {
    public static final Map<Integer, Employee> employees = new HashMap<>();

    static { //niye idk
        employees.put(356712, new Employee(356712, "cardiology", "Alonso Flores", "ON_CALL"));
        employees.put(564134, new Employee(564134, "immunology", "Sam Ortega", "ON"));
        employees.put(761527, new Employee(761527, "cardiology", "German Ruiz", "OFF"));
        employees.put(166552, new Employee(166552, "pulmonary", "Maria Lin", "ON"));
        employees.put(156545, new Employee(156545, "orthopaedic", "Paolo Rodriguez", "ON_CALL"));
        employees.put(172456, new Employee(172456, "psychiatric", "John Paul Armes", "OFF"));
    }

}
