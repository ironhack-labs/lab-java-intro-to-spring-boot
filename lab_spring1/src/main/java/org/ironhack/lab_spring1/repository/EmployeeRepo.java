package org.ironhack.lab_spring1.repository;

import lombok.extern.apachecommons.CommonsLog;
import org.ironhack.lab_spring1.entity.Employee;
import org.ironhack.lab_spring1.enums.EmployeeStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
@Component
public class EmployeeRepo {

    public final HashMap<Integer, Employee> employees=new HashMap<>();


    public EmployeeRepo() {
        employees.put(356712, new Employee(356712, "cardiology", "Alonso Flores", EmployeeStatus.ON_CALL));
        employees.put(564134, new Employee(564134, "immunology", "Sam Ortega", EmployeeStatus.ON));
        employees.put(761527, new Employee(761527, "cardiology", "German Ruiz", EmployeeStatus.OFF));
        employees.put(166552, new Employee(166552, "pulmonary", "Maria Lin", EmployeeStatus.ON));
        employees.put(156545, new Employee(156545, "orthopaedic", "Paolo Rodriguez", EmployeeStatus.ON_CALL));
        employees.put(172456, new Employee(172456, "psychiatric", "John Paul Armes", EmployeeStatus.OFF));
    }
}
