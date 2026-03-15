package com.example.lab_java_intro_to_spring_boot.controller;

import com.example.lab_java_intro_to_spring_boot.model.Employee;
import com.example.lab_java_intro_to_spring_boot.model.Status;
import com.example.lab_java_intro_to_spring_boot.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	private final DataService dataService;

	@Autowired
	public EmployeeController(DataService dataService) {
		this.dataService = dataService;
	}

	@GetMapping
	public Collection<Employee> getAllDoctors() {
		return dataService.getAllEmployees();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getDoctorById(@PathVariable int id) {
		Employee doctor = dataService.getEmployeeById(id);
		if (doctor == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(doctor);
	}

	@GetMapping("/status/{status}")
	public Collection<Employee> getDoctorsByStatus(@PathVariable Status status) {
		return dataService.getEmployeesByStatus(status);
	}

	@GetMapping("/department/{department}")
	public Collection<Employee> getDoctorsByDepartment(@PathVariable String department) {
		return dataService.getEmployeesByDepartment(department);
	}
}