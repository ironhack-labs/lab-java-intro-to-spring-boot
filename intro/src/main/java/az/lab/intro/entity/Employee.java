package az.lab.intro.entity;

import java.util.HashMap;
import java.util.Map;

public class Employee {

    public static Map<Integer, EmployeeEntity> employees = new HashMap<>();

    public Employee() {
    }

    static {
        employees.put(356712, new EmployeeEntity("Alonso Flores", "cardiology", "ON_CALL"));
        employees.put(564134, new EmployeeEntity("Sam Ortega", "immunology", "ON"));
        employees.put(761527, new EmployeeEntity("German Ruiz", "cardiology", "OFF"));
        employees.put(166552, new EmployeeEntity("Maria Lin", "pulmonary", "ON"));
        employees.put(156545, new EmployeeEntity("Paolo Rodriguez", "orthopaedic", "ON_CALL"));
        employees.put(172456, new EmployeeEntity("John Paul Armes", "psychiatric", "OFF"));
    }

    public static Map<Integer, EmployeeEntity> getEmployees() {
        return employees;
    }

}
