package com.springBoot;


import com.springBoot.enums.StatusOfEmployee;
import com.springBoot.model.Employee;
import com.springBoot.model.Patient;
import com.springBoot.repository.EmployeeRepository;
import com.springBoot.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public void run (String... args) throws Exception{
        //insertar empleados
        Employee employee1 = new Employee();
        employee1.setEmployeeId(356712);
        employee1.setDepartment("cardiology");
        employee1.setName("Alonso Flores");
        employee1.setStatus(StatusOfEmployee.ON_CALL);
        employeeRepository.save(employee1);

        Employee employee2 = new Employee();
        employee2.setEmployeeId(564134);
        employee2.setDepartment("immunology");
        employee2.setName("Sam Ortega");
        employee2.setStatus(StatusOfEmployee.ON);
        employeeRepository.save(employee2);

        Employee employee3 = new Employee();
        employee3.setEmployeeId(761527);
        employee3.setDepartment("cardiology");
        employee3.setName("German Ruiz");
        employee3.setStatus(StatusOfEmployee.OFF);
        employeeRepository.save(employee3);

        Employee employee4 = new Employee();
        employee4.setEmployeeId(166552);
        employee4.setDepartment("pulmonary");
        employee4.setName("Maria Lin");
        employee4.setStatus(StatusOfEmployee.ON);
        employeeRepository.save(employee4);

        Employee employee5 = new Employee();
        employee5.setEmployeeId(156545);
        employee5.setDepartment("orthopaedic");
        employee5.setName("Paolo Rodriguez");
        employee5.setStatus(StatusOfEmployee.ON_CALL);
        employeeRepository.save(employee5);

        Employee employee6 = new Employee();
        employee6.setEmployeeId(172456);
        employee6.setDepartment("psychiatric");
        employee6.setName("John Paul Armes");
        employee6.setStatus(StatusOfEmployee.OFF);
        employeeRepository.save(employee6);

        //INSERTAR PACIENTES
        Patient patient1 = new Patient();
        patient1.setName("Jaime Jordan");
        patient1.setDateOfBirth(LocalDate.of(1984, 03, 02));
        patient1.setEmployeeId(employee2);
        patientRepository.save(patient1);

        Patient patient2 = new Patient();
        patient2.setName("Marien Garcia");
        patient2.setDateOfBirth(LocalDate.of(1972, 01, 12));
        patient2.setEmployeeId(employee2);
        patientRepository.save(patient2);

        Patient patient3 = new Patient();
        patient3.setName("Julia Dusterdieck");
        patient3.setDateOfBirth(LocalDate.of(1954, 06, 11));
        patient3.setEmployeeId(employee1);
        patientRepository.save(patient3);

        Patient patient4 = new Patient();
        patient4.setName("Steve McDuck");
        patient4.setDateOfBirth(LocalDate.of(1931, 11, 10));
        patient4.setEmployeeId(employee3);
        patientRepository.save(patient4);

        Patient patient5 = new Patient();
        patient5.setName("Marian Garcia");
        patient5.setDateOfBirth(LocalDate.of(1999, 02, 15));
        patient5.setEmployeeId(employee6);
        patientRepository.save(patient5);

    }
}
