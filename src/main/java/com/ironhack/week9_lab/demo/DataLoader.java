package com.ironhack.week9_lab.demo;

import com.ironhack.week9_lab.enums.Status;
import com.ironhack.week9_lab.model.Employee;
import com.ironhack.week9_lab.model.Patient;
import com.ironhack.week9_lab.repository.EmployeeRepository;
import com.ironhack.week9_lab.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    final private EmployeeRepository employeeRepository;
    final private PatientRepository patientRepository;
    @Override
    public void run(String... args) throws Exception {

        Employee emp1 = new Employee( "cardiology", "Alonso Flores", Status.ON_CALL);
        Employee emp2 = new Employee("immunology", "Sam Ortega", Status.ON);
        Employee emp3 = new Employee( "cardiology", "German Ruiz", Status.OFF);
        Employee emp4 = new Employee( "pulmonary", "Maria Lin", Status.ON);
        Employee emp5 = new Employee( "orthopaedic", "Paolo Rodriguez", Status.ON_CALL);
        Employee emp6 = new Employee( "psychiatric", "John Paul Armes", Status.OFF);

        employeeRepository.saveAll(List.of(emp1, emp2, emp3, emp4, emp5, emp6));

        // Create patients
        Patient pat1 = new Patient( "Jaime Jordan", LocalDate.of(1984, 3, 2), emp2);
        Patient pat2 = new Patient( "Marian Garcia", LocalDate.of(1972, 1, 12), emp2);
        Patient pat3 = new Patient( "Julia Dusterdieck", LocalDate.of(1954, 6, 11), emp1);
        Patient pat4 = new Patient( "Steve McDuck", LocalDate.of(1931, 11, 10), emp3);
        Patient pat5 = new Patient( "Marian Garcia", LocalDate.of(1999, 2, 15), emp6);

        patientRepository.saveAll(Arrays.asList(pat1, pat2, pat3, pat4, pat5));

    }
}
