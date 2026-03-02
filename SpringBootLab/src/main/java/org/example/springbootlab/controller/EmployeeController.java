package org.example.springbootlab.controller;

import org.example.springbootlab.entity.Employee;
import org.example.springbootlab.enums.EmployeeStatus;
import org.example.springbootlab.repository.InMemoryEmployeeDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final InMemoryEmployeeDb db;

    public EmployeeController(InMemoryEmployeeDb db) {
        this.db = db;
    }

    @GetMapping("/doctors")
    public List<Employee> getDoctors() {
        return new ArrayList<>(db.employees.values());
    }

    @GetMapping("/{id}")
    public Employee getDoctorById(@PathVariable Integer id) {
        return db.employees.get(id);
    }

    @GetMapping("/status/{status}")
    public List<Employee> getDoctorsByStatus(@PathVariable String status) {
        List<Employee> result = new ArrayList<>();
        EmployeeStatus st = EmployeeStatus.valueOf(status.toUpperCase());

        for (Employee e : db.employees.values()) {
            if (e.getStatus() == st) {
                result.add(e);
            }
        }
        return result;
    }

    @GetMapping("/department/{department}")
    public List<Employee> getDoctorsByDepartment(@PathVariable String department) {
        List<Employee> result = new ArrayList<>();

        for (Employee e : db.employees.values()) {
            if (e.getDepartment().equalsIgnoreCase(department)) {
                result.add(e);
            }
        }
        return result;
    }
}
