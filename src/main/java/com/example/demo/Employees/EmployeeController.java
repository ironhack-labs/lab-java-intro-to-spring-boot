package com.example.demo.Employees;

import com.example.demo.Seed;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
public class EmployeeController {
    @GetMapping("/doctors/all")
    public Collection<Employee> getAllDoctors() {

        return Seed.employees.values();
    }

    @GetMapping("/doctors/{id}")
    public Employee getDoctorById(@PathVariable String id) {
        return Seed.employees.get(id);
    }

    @GetMapping("/doctors/status/{status}")
    public List<Employee> getDoctorByStatus(@PathVariable EmployeeStatus status) {
        List<Employee> doctors = new ArrayList<>();
        for (Employee employee : Seed.employees.values()) {
            if(employee.getStatus() == status) {
                doctors.add(employee);
            }
        }
        return doctors;
    }

    @GetMapping("/doctors/department/{department}")
    public List<Employee> getDoctorByDepartment(@PathVariable String department) {
        List<Employee> doctors = new ArrayList<>();
        for (Employee employee : Seed.employees.values()) {
            if(employee.getDepartment().equalsIgnoreCase(department)) {
                doctors.add(employee);
            }
        }
        return doctors;
    }
}
