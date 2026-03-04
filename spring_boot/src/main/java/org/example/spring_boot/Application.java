package org.example.spring_boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    private EmployeeRepository employeeRepo;

    @Autowired
    private PatientRepository patientRepo;
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String ... args) throws Exception {
                List<Employee> doctors = List.of(
                new Employee(356712L, "cardiology", "Alonso Flores", "ON_CALL"),
                new Employee(564134L, "immunology", "Sam Ortega", "ON"),
                new Employee(761527L, "cardiology", "German Ruiz", "OFF"),
                new Employee(166552L, "pulmonary", "Maria Lin", "ON"),
                new Employee(156545L, "orthopaedic", "Paolo Rodriguez", "ON_CALL"),
                new Employee(172456L, "psychiatric", "John Paul Armes", "OFF")
        );
        employeeRepo.saveAll(doctors);

        Patient p1 = new Patient(1L, "Jaime Jordan", LocalDate.of(1984, 3, 2));
        p1.setAdmitted_by(employeeRepo.findById(564134L).get());

        Patient p2 = new Patient(2L, "Marian Garcia", LocalDate.of(1972, 1, 12));
        p2.setAdmitted_by(employeeRepo.findById(564134L).get());

        Patient p3 = new Patient(3L, "Julia Dusterdieck", LocalDate.of(1954, 6, 11));
        p3.setAdmitted_by(employeeRepo.findById(356712L).get());

        Patient p4 = new Patient(4L, "Steve McDuck", LocalDate.of(1931, 11, 10));
        p4.setAdmitted_by(employeeRepo.findById(761527L).get());

        Patient p5 = new Patient(5L, "Marian Garcia", LocalDate.of(1999, 2, 15));
        p5.setAdmitted_by(employeeRepo.findById(172456L).get());

        patientRepo.saveAll(List.of(p1, p2, p3, p4, p5));

        System.out.println("Added all hospital information");
    }
}
