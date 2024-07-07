package com.ironhack.lab_java_intro_to_spring_boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.ironhack.lab_java_intro_to_spring_boot.model.Employee;
import com.ironhack.lab_java_intro_to_spring_boot.repository.EmployeeRepository;

@SpringBootApplication
 class LabJavaIntroToSpringBootApplication {
	@Autowired
//	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(LabJavaIntroToSpringBootApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		Employee employee1 = new Employee();
//		employee1.setName("Paco");
//
//		employeeRepository.save(employee1);
//	}
}