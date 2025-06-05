package com.example.hospital;

import org.springframework.boot.SpringApplication;

public class TestHospitalApplication {

	public static void main(String[] args) {
		SpringApplication.from(HospitalApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
