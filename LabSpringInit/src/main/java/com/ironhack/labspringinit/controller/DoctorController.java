package com.ironhack.labspringinit.controller;

import com.ironhack.labspringinit.data.HospitalData;
import com.ironhack.labspringinit.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {


    @GetMapping
    public List<Employee> getAllDoctors() {
        return HospitalData.employees.values().stream().toList();
    }


    @GetMapping("/{id}")
    public Employee getDoctorById(@PathVariable int id) {
        return HospitalData.employees.get(id);
    }


    @GetMapping("/status/{status}")
    public List<Employee> getDoctorsByStatus(@PathVariable String status) {
        return HospitalData.employees.values().stream()
                .filter(d -> d.getStatus().equalsIgnoreCase(status))
                .toList();
    }

    @GetMapping("/department/{department}")
    public List<Employee> getDoctorsByDepartment(@PathVariable String department) {
        return HospitalData.employees.values().stream()
                .filter(d -> d.getDepartment().equalsIgnoreCase(department))
                .toList();
    }
}