package com.ironhack.week_9_lab.demo;


import com.ironhack.week_9_lab.model.Employee;
import com.ironhack.week_9_lab.model.Patient;
import com.ironhack.week_9_lab.repository.EmployeeRepository;
import com.ironhack.week_9_lab.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataLoader {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Bean
    public CommandLineRunner loadData() {
        return args -> {
            // Load Employee data
            employeeRepository.saveAll(List.of(
                    new Employee(356712L, "cardiology", "Alonso Flores", "ON_CALL"),
                    new Employee(564134L, "immunology", "Sam Ortega", "ON"),
                    new Employee(761527L, "cardiology", "German Ruiz", "OFF"),
                    new Employee(166552L, "pulmonary", "Maria Lin", "ON"),
                    new Employee(156545L, "orthopaedic", "Paolo Rodriguez", "ON_CALL"),
                    new Employee(172456L, "psychiatric", "John Paul Armes", "OFF")
            ));

            // Load Patient data
            patientRepository.saveAll(List.of(
                    new Patient(1L, "Jaime Jordan", "1984-03-02", employeeRepository.findById(564134L).orElse(null)),
                    new Patient(2L, "Marian Garcia", "1972-01-12", employeeRepository.findById(564134L).orElse(null)),
                    new Patient(3L, "Julia Dusterdieck", "1954-06-11", employeeRepository.findById(356712L).orElse(null)),
                    new Patient(4L, "Steve McDuck", "1931-11-10", employeeRepository.findById(761527L).orElse(null)),
                    new Patient(5L, "Marian Garcia", "1999-02-15", employeeRepository.findById(172456L).orElse(null))
            ));
        };
    }
}
