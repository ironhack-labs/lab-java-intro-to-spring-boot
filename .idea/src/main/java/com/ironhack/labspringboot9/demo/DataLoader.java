package com.ironhack.labspringboot9.demo;

import com.ironhack.labspringboot9.enums.Status;
import com.ironhack.labspringboot9.model.Employee;
import com.ironhack.labspringboot9.model.Patient;
import com.ironhack.labspringboot9.repository.EmployeeRepository;
import com.ironhack.labspringboot9.repository.PatientRepository;
import jakarta.persistence.ForeignKey;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.ObjectInputFilter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    @Autowired
    private final EmployeeRepository employeeRepository;
    @Autowired
    private final PatientRepository patientRepository;

    @Override
    public void run(String... args) throws Exception {
        Employee employee1=new Employee(356712L, Status.ON_CALL,"cardiology","Alonso Flores");
        Employee employee2=new Employee(564134L, Status.ON,"immunology","Sam Ortega");
        Employee employee3=new Employee(761527L, Status.OFF,"cardiology","German Ruiz");
        Employee employee4= new Employee(166552L, Status.ON,"pulmonary","Maria Lin");
        Employee employee5=new Employee(156545L, Status.ON_CALL,"orthopaedic","Paolo Rodriguez");
        Employee employee6=new Employee(172456L, Status.OFF,"psychiatric","John Paul Armes");
        var listOfEmployees=List.of(employee1,employee2,employee3,employee4,employee5,employee6);
        employeeRepository.saveAll(listOfEmployees);

        Patient patient1 = new Patient("Jaime Jordan", new Date(1984, Calendar.MARCH,2),employee2);
        Patient patient2 = new Patient("Marian Garcia", new Date(1972,Calendar.JANUARY,12),employee2);
        Patient patient3 = new Patient("Julia Dusterdieck", new Date(1954,Calendar.JUNE,11),employee1);
        Patient patient4 = new Patient("Steve McDuck", new Date(1931,Calendar.NOVEMBER,10),employee3);
        Patient patient5 = new Patient("Marian Garcia", new Date(1999,Calendar.FEBRUARY,15),employee6);
        var listOfPatients=List.of(patient1,patient2,patient3,patient4,patient5);
        patientRepository.saveAll(listOfPatients);

    }
}
