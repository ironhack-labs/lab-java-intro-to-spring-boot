package spring_lessons.introTo_springBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import spring_lessons.introTo_springBoot.model.Employee;
import spring_lessons.introTo_springBoot.repository.EmployeeRepository;

@SpringBootApplication
public class IntroToSpringBootApplication {

//	@Autowired
//	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(IntroToSpringBootApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		Employee employee1 = new Employee();
//		employee1.setName("Paco");
//
//		employeeRepository.save(employee1);
//	}
}
