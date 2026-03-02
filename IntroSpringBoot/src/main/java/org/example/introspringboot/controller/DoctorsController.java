package org.example.introspringboot.controller;

import org.example.introspringboot.Data.InMemoryDb;
import org.example.introspringboot.model.Employee;
import org.example.introspringboot.model.Status;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import javax.print.Doc;
import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorsController {

    private final InMemoryDb db;

    public DoctorsController(InMemoryDb db) {
        this.db = db;
    }

    @GetMapping("/all")
    public List<Employee> getAllDoctors() {
        return db.getAllEmployees().stream().toList();
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getDoctorById(@PathVariable int employeeId ) {
        Employee doctorById = db.getEmployeeById(employeeId);
        if (doctorById == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(doctorById);
    }

    @GetMapping("/status/{status}")
    public List<Employee> getDoctorsByStatus(@PathVariable Status status) {
        List<Employee> doctorsByStatus = db.getAllEmployees()
                .stream()
                .filter(e -> e.getStatus() == status)
                .toList();
        return doctorsByStatus;
    }

@GetMapping("/department/{department}")
    public List<Employee> getDoctorsByStatus(@PathVariable String department) {
        List<Employee> doctorsByDepartment = db.getAllEmployees()
                .stream()
                .filter(e ->
                        e.getDepartment().toLowerCase().equals(department.toLowerCase()))
                .toList();
        return doctorsByDepartment;
    }
}

