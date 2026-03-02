package com.ironhack.intro_to_spring_boot.database;

import com.ironhack.intro_to_spring_boot.entities.Employee;
import com.ironhack.intro_to_spring_boot.entities.Patient;

import java.util.HashMap;
import java.util.Map;
import com.ironhack.intro_to_spring_boot.enums.Status.*;
import org.springframework.stereotype.Component;

import static com.ironhack.intro_to_spring_boot.enums.Status.*;

@Component
public class AllEmployeesAndPatients {
    public Map<Long, Employee> employees = new HashMap<>();
    public Map<Long, Patient> patients = new HashMap<>();
    public AllEmployeesAndPatients() {
		employees.put(356712L, new Employee(356712L, "cardiology", "Alonso Flores", ON_CALL));
		employees.put(564134L, new Employee(564134L, "immunology", "Sam Ortega", ON));
		employees.put(761527L, new  Employee(761527L, "cardiology", "German Ruiz",OFF));
		employees.put(166552L, new Employee(166552L, "pulmonary", "Maria Lin", ON));
		employees.put(156545L, new Employee(156545L, "orthopaedic", "Paolo Rodriguez", ON_CALL));
		employees.put(172456L, new Employee(172456L, "psychiatric", "John Paul Armes", OFF));

		patients.put(1L, new Patient(1L, "Jaime Jordan", "1984-03-02",564134L));
		patients.put(2L, new Patient(2L, "Marian Garcia", "1972-01-12",564134L));
		patients.put(3L, new Patient(3L, "Julia Dusterdieck", "1954-06-11",356712L));
		patients.put(4L, new Patient(4L, "Steve McDuck", "1931-11-10",761527L));
		patients.put(5L, new Patient(5L, "Marian Garcia", "1999-02-15",172456L));
    }
}
