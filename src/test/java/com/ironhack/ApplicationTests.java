package com.ironhack;

import com.ironhack.model.Employee;
import com.ironhack.model.Patient;
import com.ironhack.repository.EmployeeRepository;
import com.ironhack.repository.PatientRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	PatientRepository patientRepository;

	@BeforeEach
	void setUp() {
		//Employees
		employeeRepository.save(new Employee(356712,"cardiology","Alonso Flores", Employee.Status.ON_CALL.toString()));
		employeeRepository.save(new Employee(564134,"immunology", "Sam Ortega", Employee.Status.ON.toString()));
		employeeRepository.save(new Employee(761527,"cardiology", "German Ruiz", Employee.Status.OFF.toString()));
		employeeRepository.save(new Employee(166552,"pulmonary", "Maria Lin", Employee.Status.ON.toString()));
		employeeRepository.save(new Employee(156545,"orthopaedic", "Paolo Rodriguez", Employee.Status.ON_CALL.toString()));
		employeeRepository.save(new Employee(172456,"psychiatric", "John Paul Armes", Employee.Status.OFF.toString()));

		//Patients

		patientRepository.save(new Patient("Jaime Jordan", LocalDate.parse("1984-03-02"), employeeRepository.findById(564134).get()));
		patientRepository.save(new Patient("Marian Garcia", LocalDate.parse("1972-01-12"), employeeRepository.findById(564134).get()));
		patientRepository.save(new Patient("Julia Dusterdieck", LocalDate.parse("1954-06-11"), employeeRepository.findById(356712).get()));
		patientRepository.save(new Patient("Steve McDuck", LocalDate.parse("1931-11-10"), employeeRepository.findById(761527).get()));
		patientRepository.save(new Patient("Marian Garcia", LocalDate.parse("1999-02-15"), employeeRepository.findById(172456).get()));
	}

//	@AfterEach
//	void tearDown() {
//		patientRepository.deleteAll();
//		employeeRepository.deleteAll();
//	}

	@Test
	void contextLoads() {
	}



}
