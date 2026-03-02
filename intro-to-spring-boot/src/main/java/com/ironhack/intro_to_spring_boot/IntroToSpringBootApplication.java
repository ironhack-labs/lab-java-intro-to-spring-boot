package com.ironhack.intro_to_spring_boot;

import com.ironhack.intro_to_spring_boot.entities.Employee;
import com.ironhack.intro_to_spring_boot.entities.Patient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;import java.util.HashMap;
import java.util.Map;import static com.ironhack.intro_to_spring_boot.enums.Status.*;

@SpringBootApplication
public class IntroToSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntroToSpringBootApplication.class, args);

	}
}
