package com.labs.lab_intro_to_spring_boot.controller.interfaces;

import com.labs.lab_intro_to_spring_boot.model.Employee;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IEmployeeController {
    List<Employee> getAllDoctors();
    Employee getDoctorById(Long employeeId);
    List<Employee> getDoctorsByDepertment(@RequestParam String department);
    List<Employee> getDoctorsByStatus(@RequestParam String status);
}
