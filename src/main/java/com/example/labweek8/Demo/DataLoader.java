package com.example.labweek8.Demo;

import com.example.labweek8.Model.Employee;
import com.example.labweek8.Model.Patient;
import com.example.labweek8.Repository.EmployeeRepository;
import com.example.labweek8.Repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static com.example.labweek8.Model.Status.*;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor


public class DataLoader implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;
    private final PatientRepository patientRepository;


    @Override
    public void run(String... args) throws Exception {

       employeeRepository.saveAll(List.of(
               new Employee(356712, "Alonso Flores", "Cardiology",ON_CALL),
               new Employee(564134, "Sam Ortega", "Immunology", ON),
               new Employee(761527, "German Ruiz", "Cardilogy", OFF),
               new Employee (166552, "Maria Lin", "Pulmunary", ON),
               new Employee( 156545,"Paolo Rodriguez", "Orthopaedic", ON_CALL),
               new Employee(172456, "John Paul Armes", "Psychiatric", OFF)
       ));
    }


}
