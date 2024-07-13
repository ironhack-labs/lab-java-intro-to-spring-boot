package com.ironhack.week9_lab.demo;

import com.ironhack.week9_lab.model.Employee;
import com.ironhack.week9_lab.model.EmployeeStatus;
import com.ironhack.week9_lab.model.Patient;
import com.ironhack.week9_lab.repository.EmployeeRepository;
import com.ironhack.week9_lab.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;
    private final PatientRepository patientRepository;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final JdbcTemplateAutoConfiguration jdbcTemplateAutoConfiguration;


    @Override
    public void run(String... args) throws Exception {
        Employee employee1 = new Employee("Cardiology", "Alonso Flores", EmployeeStatus.NO_CALL);
        employeeRepository.save(employee1);
        Employee employee2 = new Employee("immunology", " Sam Ortega", EmployeeStatus.NO);
        employeeRepository.save(employee2);
        Employee employee3 = new Employee("Cardiology", "German Ruiz", EmployeeStatus.OFF);
        employeeRepository.save(employee3);


        Patient patient1 = new Patient("Jaime Jordan", (LocalDate.of(1984, 3, 2)), "Employee1");
        patientRepository.save(patient1);
    }
}

// (356712,	'cardiology','Alonso Flores',	'ON_CALL'),
 // ( 564134,	'immunology',	'Sam Ortega'	'ON'),
// (761527,	'cardiology',	'German Ruiz'	'OFF'),
 // (166552,	'pulmonary',	'Maria Lin',  	'ON'),
//  (156545,	'orthopaedic',	'Paolo Rodriguez'.	'ON_CALL'),
//  (172456,	'psychiatric',	'John Paul Armes',	'OFF'),

