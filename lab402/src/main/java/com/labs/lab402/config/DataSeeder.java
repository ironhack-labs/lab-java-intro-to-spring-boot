package com.labs.lab402.config;

import com.labs.lab402.model.Employee;
import com.labs.lab402.model.Patient;
import com.labs.lab402.repository.EmployeeRepository;
import com.labs.lab402.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class DataSeeder {

    @Bean
    public CommandLineRunner seedDatabase(EmployeeRepository employeeRepo, PatientRepository patientRepo) {
        return args -> {
            // Create employees
            Employee emp1 = new Employee(356712L, "cardiology", "Alonso Flores", "ON_CALL");
            Employee emp2 = new Employee(564134L, "immunology", "Sam Ortega", "ON");
            Employee emp3 = new Employee(761527L, "cardiology", "German Ruiz", "OFF");
            Employee emp4 = new Employee(166552L, "pulmonary", "Maria Lin", "ON");
            Employee emp5 = new Employee(156545L, "orthopaedic", "Paolo Rodriguez", "ON_CALL");
            Employee emp6 = new Employee(172456L, "psychiatric", "John Paul Armes", "OFF");

            employeeRepo.save(emp1);
            employeeRepo.save(emp2);
            employeeRepo.save(emp3);
            employeeRepo.save(emp4);
            employeeRepo.save(emp5);
            employeeRepo.save(emp6);

            // Create patients
            Patient p1 = new Patient(1L, "Jaime Jordan", LocalDate.of(1984, 3, 2), emp2);
            Patient p2 = new Patient(2L, "Marian Garcia", LocalDate.of(1972, 1, 12), emp2);
            Patient p3 = new Patient(3L, "Julia Dusterdieck", LocalDate.of(1954, 6, 11), emp1);
            Patient p4 = new Patient(4L, "Steve McDuck", LocalDate.of(1931, 11, 10), emp3);
            Patient p5 = new Patient(5L, "Marian Garcia", LocalDate.of(1999, 2, 15), emp6);

            patientRepo.save(p1);
            patientRepo.save(p2);
            patientRepo.save(p3);
            patientRepo.save(p4);
            patientRepo.save(p5);
        };
    }
}


