package spring_lessons.introTo_springBoot.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring_lessons.introTo_springBoot.model.Employee;
import spring_lessons.introTo_springBoot.model.Status;
import spring_lessons.introTo_springBoot.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/doctors")
    public List<Employee> getAllDoctors(){
        return employeeRepository.findAll();
    }

    @GetMapping("/doctor/{id}")
    public Employee getDoctorById(@PathVariable Integer id){
        Optional<Employee> doctorOptional = employeeRepository.findById(id);
        return doctorOptional.orElse(null);
    }

    @GetMapping("/doctors/status")
    public List<Employee> getDoctorsByStatus(@RequestParam Status status){
        return employeeRepository.findAllByStatus(status);
    }

    @GetMapping("/doctors/department")
    public List<Employee> getDoctorsByDepartment(@RequestParam String department){
        return employeeRepository.findAllByDepartment(department);
    }

}
