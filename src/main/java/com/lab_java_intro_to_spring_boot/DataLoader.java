package com.lab_java_intro_to_spring_boot;

import com.lab_java_intro_to_spring_boot.model.Employee;
import com.lab_java_intro_to_spring_boot.Enums.EmployeeDepartment;
import com.lab_java_intro_to_spring_boot.Enums.EmployeeStatus;
import com.lab_java_intro_to_spring_boot.model.Patient;
import com.lab_java_intro_to_spring_boot.repository.EmployeeRepository;
import com.lab_java_intro_to_spring_boot.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public void run(String... args) throws Exception{

        // patients
        //
        Employee employee;
        List<Employee> employees=  new ArrayList<>();

        employee=new Employee();
        employee.setId(356712);
        employee.setDepartment(EmployeeDepartment.CARDIOLOGY);
        employee.setName("Alonso Flores");
        employee.setStatus(EmployeeStatus.ON_CALL);
        employees.add(employee);

        employee=new Employee();
        employee.setId(564134);
        employee.setDepartment(EmployeeDepartment.INMMUNOLOGY);
        employee.setName("Sam Ortega");
        employee.setStatus(EmployeeStatus.ON);
        employees.add(employee);

        employee=new Employee();
        employee.setId(761527);
        employee.setDepartment(EmployeeDepartment.CARDIOLOGY);
        employee.setName("German Ruiz");
        employee.setStatus(EmployeeStatus.OFF);
        employees.add(employee);

        employee=new Employee();
        employee.setId(166552);
        employee.setDepartment(EmployeeDepartment.PULMONARY);
        employee.setName("Maria Lin");
        employee.setStatus(EmployeeStatus.ON);
        employees.add(employee);

        employee=new Employee();
        employee.setId(156545);
        employee.setDepartment(EmployeeDepartment.ORTHOPAEDIC);
        employee.setName("Paolo Rodriguez");
        employee.setStatus(EmployeeStatus.ON_CALL);
        employees.add(employee);

        employee=new Employee();
        employee.setId(172456);
        employee.setDepartment(EmployeeDepartment.PSYCHIATRIC);
        employee.setName("John Paul Armes");
        employee.setStatus(EmployeeStatus.OFF);
        employees.add(employee);

        employeeRepository.saveAll(employees);

        // patients
        //
        Patient patient;
        List<Patient> patients=new ArrayList<>();

        patient=new Patient();
        patient.setName("Jaime Jordan");
        patient.setDateOfBirth(LocalDate.parse("1984-03-02") );
        patient.setAdmittedBy(employeeRepository.getReferenceById(564134));
        patients.add(patient);

        patient=new Patient();
        patient.setName("Marian Garcia");
        patient.setDateOfBirth(LocalDate.parse("1972-01-12") );
        patient.setAdmittedBy(employeeRepository.getReferenceById(564134));
        patients.add(patient);

        patient=new Patient();
        patient.setName("Julia Dusterdieck");
        patient.setDateOfBirth(LocalDate.parse("1954-06-11") );
        patient.setAdmittedBy(employeeRepository.getReferenceById(356712));
        patients.add(patient);

        patient=new Patient();
        patient.setName("Steve McDuck");
        patient.setDateOfBirth(LocalDate.parse("1931-11-10") );
        patient.setAdmittedBy(employeeRepository.getReferenceById(761527));
        patients.add(patient);

        patient=new Patient();
        patient.setName("Marian Garcia");
        patient.setDateOfBirth(LocalDate.parse("1999-02-15") );
        patient.setAdmittedBy(employeeRepository.getReferenceById(172456));
        patients.add(patient);

        patientRepository.saveAll(patients);
    }
}
