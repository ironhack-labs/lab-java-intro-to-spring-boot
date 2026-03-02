package com.example.demo;

import com.example.demo.Controller.DataStore;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class DemoApplication {
	public static void main(String[] args) {
		DataStore.Seed();
		SpringApplication.run(DemoApplication.class, args);
	}
}
