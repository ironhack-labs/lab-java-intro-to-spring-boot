package com.ironhack.lab401.controller.impl;

import com.ironhack.lab401.controller.interfaces.IEmployeeController;
import com.ironhack.lab401.model.Employee;
import com.ironhack.lab401.model.EmployeeStatus;
import com.ironhack.lab401.repository.EmployeeRepository;
import com.ironhack.lab401.service.interfaces.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController implements IEmployeeController {

    @Autowired
    IEmployeeService employeeService;

    @GetMapping("/doctors")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public List<Employee> getAllDoctor() {
        return employeeService.getAllDoctor();
    }

    @GetMapping("/doctors/{employee_id}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public Employee getDoctorById(@PathVariable Integer employee_id) {
        return employeeService.getDoctorById(employee_id);
    }

    @GetMapping("/doctors/status")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public List<Employee> getDoctorByStatus(@RequestParam EmployeeStatus employeeStatus) {
        return employeeService.getDoctorByStatus(employeeStatus);
    }

    @GetMapping("/doctors/department")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public List<Employee> getDoctorByDepartment(@RequestParam String department) {
        return employeeService.getDoctorByDepartment(department);
    }

//    @PostMapping("/doctors")
//    @ResponseStatus(HttpStatus.CREATED)
//    @Override
//    public void saveDoctor(@RequestBody Employee doctor){
//        employeeService.saveDoctor(doctor);
//    }




}
