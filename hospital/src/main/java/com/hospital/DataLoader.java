package com.hospital;

import com.hospital.enums.Department;
import com.hospital.enums.Status;
import com.hospital.model.Employee;
import com.hospital.model.Patient;
import com.hospital.repository.EmployeeRepository;
import com.hospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    PatientRepository patientRepository;
    @Override
    public void run(String... args) throws Exception {
        Employee employee1 = new Employee();
        employee1.setEmployee_id(356712l);
        employee1.setDepartment(Department.cardiology);
        employee1.setName("Alonso FLores");
        employee1.setStatus(Status.ON_CALL);
        employeeRepository.save(employee1);

        Employee employee2 = new Employee();
        employee2.setEmployee_id(564134l);
        employee2.setDepartment(Department.immunology);
        employee2.setName("Sam Ortega");
        employee2.setStatus(Status.ON);
        employeeRepository.save(employee2);

        Employee employee3 = new Employee();
        employee3.setEmployee_id(761527l);
        employee3.setDepartment(Department.cardiology);
        employee3.setName("German Ruiz");
        employee3.setStatus(Status.OFF);
        employeeRepository.save(employee3);

        Employee employee4 = new Employee();
        employee4.setEmployee_id(166552l);
        employee4.setDepartment(Department.pulmonary);
        employee4.setName("Maria Lin");
        employee4.setStatus(Status.ON);
        employeeRepository.save(employee4);

        Employee employee5 = new Employee();
        employee5.setEmployee_id(156545l);
        employee5.setDepartment(Department.orthopaedic);
        employee5.setName("Paolo Rodriguez");
        employee5.setStatus(Status.ON_CALL);
        employeeRepository.save(employee5);

        Employee employee6 = new Employee();
        employee6.setEmployee_id(172456l);
        employee6.setDepartment(Department.psychiatric);
        employee6.setName("Paolo Rodriguez");
        employee6.setStatus(Status.OFF);
        employeeRepository.save(employee6);

        Patient patient1 = new Patient();
        patient1.setName("Jaime Jordan");
        patient1.setDateOfBirth(LocalDate.of(1984,3,2));
        patient1.setAdmittedBy(employee2);
        patientRepository.save(patient1);

        Patient patient2 = new Patient();
        patient2.setName("Marian Garcia");
        patient2.setDateOfBirth(LocalDate.of(1972,1,12));
        patient2.setAdmittedBy(employee2);
        patientRepository.save(patient2);

        Patient patient3 = new Patient();
        patient3.setName("Julia Dusterdieck");
        patient3.setDateOfBirth(LocalDate.of(1954,6,11));
        patient3.setAdmittedBy(employee1);
        patientRepository.save(patient3);

        Patient patient4 = new Patient();
        patient4.setName("Steve McDuck");
        patient4.setDateOfBirth(LocalDate.of(1931,11,10));
        patient4.setAdmittedBy(employee3);
        patientRepository.save(patient4);

        Patient patient5 = new Patient();
        patient5.setName("Marian Garcia");
        patient5.setDateOfBirth(LocalDate.of(1999,2,15));
        patient5.setAdmittedBy(employee6);
        patientRepository.save(patient5);

    }

}
