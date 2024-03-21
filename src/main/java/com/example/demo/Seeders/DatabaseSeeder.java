package com.example.demo.Seeders;

import com.example.demo.Classes.Employee;
import com.example.demo.Classes.Patient;
import com.example.demo.Repositories.EmployeeRepository;
import com.example.demo.Repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class DatabaseSeeder implements CommandLineRunner {
    private final EmployeeRepository employeeRepository;
    private final PatientRepository patientRepository;

    public DatabaseSeeder(EmployeeRepository employeeRepository, PatientRepository patientRepository) {
        this.employeeRepository = employeeRepository;
        this.patientRepository = patientRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        // create and save Employee objects
        Employee e1 = new Employee(356712L, "cardiology", "Alonso Flores", "ON_CALL");
        Employee e2 = new Employee(564134L, "immunology", "Sam Ortega", "ON");
        Employee e3 = new Employee(761527L, "cardiology", "German Ruiz", "OFF");
        Employee e4 = new Employee(166552L, "pulmonary", "Maria Lin", "ON");
        Employee e5 = new Employee(156545L, "orthopaedic", "Paolo Rodriguez", "ON_CALL");
        Employee e6 = new Employee(172456L, "psychiatric", "John Paul Armes", "OFF");

        employeeRepository.save(e1);
        employeeRepository.save(e2);
        employeeRepository.save(e3);
        employeeRepository.save(e4);
        employeeRepository.save(e5);
        employeeRepository.save(e6);

        // create and save Patient objects
        Patient p1 = new Patient(1L, "Jaime Jordan", Date.valueOf("1984-03-02"), e2);
        Patient p2 = new Patient(2L, "Marian Garcia", Date.valueOf("1972-01-12"), e2);
        Patient p3 = new Patient(3L, "Julia Dusterdieck", Date.valueOf("1954-06-11"), e1);
        Patient p4 = new Patient(4L, "Steve McDuck", Date.valueOf("1931-11-10"), e3);
        Patient p5 = new Patient(5L, "Marian Garcia", Date.valueOf("1999-02-15"), e6);


        patientRepository.save(p1);
        patientRepository.save(p2);
        patientRepository.save(p3);
        patientRepository.save(p4);
        patientRepository.save(p5);
    }
}
