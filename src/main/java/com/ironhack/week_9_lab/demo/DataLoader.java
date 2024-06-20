package com.ironhack.week_9_lab.demo;

import com.ironhack.week_9_lab.model.Employee;
import com.ironhack.week_9_lab.model.EmployeeStatus;
import com.ironhack.week_9_lab.model.Patient;
import com.ironhack.week_9_lab.repository.EmployeeRepository;
import com.ironhack.week_9_lab.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;
    private final PatientRepository patientRepository;

    @Override
    public void run(String... args) throws Exception {
        Employee employee1 = new Employee("cardiology", "Alonso Flores", EmployeeStatus.ON_CALL);
        employeeRepository.save(employee1);
        Employee employee2 = new Employee("immunology", "Sam Ortega", EmployeeStatus.ON);
        employeeRepository.save(employee2);
        Employee employee3 =new Employee("cardiology", "German Ruiz", EmployeeStatus.OFF);
        employeeRepository.save(employee3);
        Employee employee4 = new Employee("pulmonary", "Maria Lin", EmployeeStatus.ON );
        employeeRepository.save(employee4);
        Employee employee5 = new Employee("orthopaedic", "Paolo Rodriguez", EmployeeStatus.ON_CALL);
        employeeRepository.save(employee5);
        Employee employee6 =new Employee("psychiatric", "John Paul Armes", EmployeeStatus.OFF);
        employeeRepository.save(employee6);
        Patient patient1 = new Patient(1,"Jaime Jordan", LocalDate.of(1984,3,2), employee2);
        patientRepository.save(patient1);
        Patient patient2 = new Patient(2,"Marian Garcia", LocalDate.of(1972,1,12), employee2);
        patientRepository.save(patient2);
        Patient patient3 =new Patient(3,"Julia Dusterdieck", LocalDate.of(1954,6,11), employee1);
        patientRepository.save(patient3);
        Patient patient4 =new Patient(4, "Steve McDuck", LocalDate.of(1931,11,10), employee3);
        patientRepository.save(patient4);
        Patient patient5 = new Patient(5, "Marian Garcia", LocalDate.of(1999,2,15), employee6);
        patientRepository.save(patient5);

//        var saved = patientRepository.findByAdmittedBy_Status_On();
//        System.out.println(saved);
    }
}