package org.example.controler;

import org.example.model.Employee;
import org.example.model.Status;
import org.example.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;


@Controller
public class EmployeeController {

    @Autowired
    private IEmployeeRepository employeeRepository;
    @GetMapping("/doctors")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getDoctors() {
        return employeeRepository.findAll();
    }

    @GetMapping("/doctors/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee getDoctorById(@PathVariable(name="id") String employeeID) {
        return employeeRepository.findById(employeeID).get();
    }

    @GetMapping("/doctors/status/{status}")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getDoctorsByStatus(@PathVariable(name="status") Status status) {
        return employeeRepository.findByStatus(status).get();
    }

    @GetMapping("/doctors/department/{department}")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getDoctorsByDepartment(@PathVariable(name = "department")String department) {
        return employeeRepository.findByDepartment(department).get();
    }
}
