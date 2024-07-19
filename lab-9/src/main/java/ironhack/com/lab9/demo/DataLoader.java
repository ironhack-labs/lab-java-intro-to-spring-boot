package ironhack.com.lab9.demo;

import ironhack.com.lab9.model.Employee;
import ironhack.com.lab9.model.Patient;
import ironhack.com.lab9.repository.EmployeeRepository;
import ironhack.com.lab9.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor

public class DataLoader implements CommandLineRunner {
    private final EmployeeRepository employeeRepository;
    private final PatientRepository patientRepository;



    @Override
    public void run(String... args) throws Exception {
        Employee employee1 = new Employee("cardiology", "Alonso Flores", "ON_CALL");
        Employee employee2 = new Employee("immunology", "Sam Ortega", "ON");
        Employee employee3 = new Employee("cardiology", "German Ruiz", "OFF");
        Employee employee4 = new Employee("pulmonary", "Maria Lin", "ON");
        Employee employee5 = new Employee("orthopedic", "Paolo Rodriguez", "ON_CALL");
        Employee employee6 = new Employee("psychiatric", "John Paul Armes", "OFF");
        var listOfEmployees = List.of(employee1, employee2, employee3, employee4, employee5, employee6);
        employeeRepository.saveAll(listOfEmployees);

        Patient patient1 = new Patient("Jaime Jordan", "1984-03-02", employee2);
        Patient patient2 = new Patient("Marian Garcia", "1972-01-12", employee2);
        Patient patient3 = new Patient("Julia Dusterdieck", "1954-06-11", employee1);
        Patient patient4 = new Patient("Steve McDuck", "1931-11-10", employee3);
        Patient patient5 = new Patient("Marian Garcia", "1999-02-15", employee6);
        var listOfPatients = List.of(patient1, patient2, patient3,patient4, patient5);
        patientRepository.saveAll(listOfPatients);

    }
}
