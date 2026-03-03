package com.ironhack;

import com.ironhack.model.Employee;
import com.ironhack.model.Patient;
import com.ironhack.model.Status;
import com.ironhack.repository.EmployeeRepository;
import com.ironhack.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class Lab7Application {

    public static void main(String[] args) {
        SpringApplication.run(Lab7Application.class, args);
    }


    @Bean
    CommandLineRunner run(EmployeeRepository employeeRepository, PatientRepository patientRepository) {
        return args -> {


            Employee doc1 = new Employee(356712L, "cardiology", "Alonso Flores", Status.ON_CALL);
            Employee doc2 = new Employee(564134L, "immunology", "Sam Ortega", Status.ON);
            Employee doc3 = new Employee(761527L, "cardiology", "German Ruiz", Status.OFF);
            Employee doc4 = new Employee(166552L, "pulmonary", "Maria Lin", Status.ON);
            Employee doc5 = new Employee(156545L, "orthopaedic", "Paolo Rodriguez", Status.ON_CALL);
            Employee doc6 = new Employee(172456L, "psychiatric", "John Paul Armes", Status.OFF);


            employeeRepository.saveAll(List.of(doc1, doc2, doc3, doc4, doc5, doc6));


            Patient pat1 = new Patient("Jaime Jordan", LocalDate.of(1984, 3, 2), doc2);
            Patient pat2 = new Patient("Marian Garcia", LocalDate.of(1972, 1, 12), doc2);
            Patient pat3 = new Patient("Julia Dusterdieck", LocalDate.of(1954, 6, 11), doc1);
            Patient pat4 = new Patient("Steve McDuck", LocalDate.of(1931, 11, 10), doc3);
            Patient pat5 = new Patient("Marian Garcia", LocalDate.of(1999, 2, 15), doc6);


            patientRepository.saveAll(List.of(pat1, pat2, pat3, pat4, pat5));

            System.out.println("✅ DATABASE SEEDED WITH DUMMY DATA! READY FOR ROUTES!");
        };
    }
}