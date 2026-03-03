package com.ironhack.labspringboot.controller;

import com.ironhack.labspringboot.entity.Employee;
import com.ironhack.labspringboot.enums.Status;
import com.ironhack.labspringboot.service.HospitalManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final HospitalManager hospitalManager;

    public EmployeeController(HospitalManager hospitalManager) {
        this.hospitalManager = hospitalManager;
    }




    @GetMapping("/allDoctors")
    public List<Employee> getAllDoctors() {
        return hospitalManager.getAllDoctors();
    }

    @GetMapping("/doctors/{id}")
    public Employee getDoctorByID(@PathVariable int id ) {
        return hospitalManager.getDoctorByID(id);
    }

    @GetMapping("/doctors/byStatus/{status}")
    public List<Employee> getDoctorByStatus(@PathVariable Status status ) {
        return  hospitalManager.getDoctorByStatus(status);


    }

    @GetMapping("/doctors/byDepartment/{department}")
    public List<Employee> getDoctorByDepartment(@PathVariable String department ) {
        return hospitalManager.getDoctorByDepartment(department);
    }
}
