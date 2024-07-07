package com.example.lab_java_intro_to_spring_boot;

import com.example.lab_java_intro_to_spring_boot.model.Employee;
import com.example.lab_java_intro_to_spring_boot.model.Patient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

import static com.example.lab_java_intro_to_spring_boot.model.Status.*;

@SpringBootApplication
public class LabJavaIntroToSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabJavaIntroToSpringBootApplication.class, args);
	}

	Employee employee1 = new Employee (356712, "cardiology", "Alonso Flores",ON_CALL);
	Employee employee2 = new Employee (564134, "immunology", "Sam Ortega", ON);
	Employee employee3 = new Employee (761527, "cardiology", "Germain Ruiz", OFF);
	Employee employee4 = new Employee (166552, "pulmonary", "Maria Lin", ON);
	Employee employee5 = new Employee (156545, "orthopaedic", "Paolo Rodriguez", ON_CALL);
	Employee employee6 = new Employee (172456, "psychiatric", "John Paul Armes", OFF);

	Patient patient1 = new Patient(1, "Jaime Jordan", LocalDate.of(1984,02,03), employee2);
	Patient patient2 = new Patient(2, "Marian Garcia", LocalDate.of(1972,01,12), employee2);
	Patient patient3 = new Patient(3, "Julia Dusterdieck", LocalDate.of(1954,06,11), employee1);
	Patient patient4 = new Patient(4, "Steve McDuck", LocalDate.of(1931,11,10), employee3);
	Patient patient5 = new Patient(5, "Marian Garcia", LocalDate.of(1999,02,15),employee6);



}
