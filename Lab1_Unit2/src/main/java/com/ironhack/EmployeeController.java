package com.ironhack;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeRepository employeeRepository = new EmployeeRepository();

    //Get all doctors: Create a route to get all doctors.
    @GetMapping ("/allEmployees")
    public List<Employee> getDoctors() {
//        return getDoctors();
        return new ArrayList<>(EmployeeRepository.employees.values());
    }

    //Get doctor by ID: Create a route to get a doctor by employee_id.
    @GetMapping ("/employeesId")
    public List<Employee> getEmployee_id(){
        return new ArrayList<>(EmployeeRepository.employees.values());
    }

    //Get doctors by status: Create a route to get doctors by status.
    @GetMapping ("/employeesStatus")
    public List<Employee> getStatus() {
        return new ArrayList<>(EmployeeRepository.employees.values());

    }

    //Get doctors by department: Create a route to get doctors by department.
    @GetMapping ("/employeesDepartment")
    public List<Employee> getDepartment(){

        return new ArrayList<>(EmployeeRepository.employees.values());
    }
}
