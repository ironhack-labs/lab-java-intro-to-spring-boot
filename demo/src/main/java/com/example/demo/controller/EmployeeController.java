package com.example.demo.controller;

import com.example.demo.Employee;
import com.example.demo.Status;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


@RestController
public class EmployeeController {

    public static Map<Integer, Employee> doctors = new HashMap<>();

    public EmployeeController() {
        doctors.put(356712, new Employee(356712,"cardiology", "Alonso Flores", Status.ON_CALL));
        doctors.put(564134, new Employee(564134,"immunology", "Sam Ortega", Status.ON));
        doctors.put(761527, new Employee(761527,"cardiology", "German Ruiz", Status.OFF));
        doctors.put(166552, new Employee(166552,"pulmonary", "Maria Lin", Status.ON));
        doctors.put(156545, new Employee(156545,"orthopaedic", "Paolo Rodriguez", Status.ON_CALL));
        doctors.put(172456, new Employee(172456,"psychiatric", "John Paul Armes", Status.OFF));

    }

    @GetMapping("/doctors")
    public List<Employee> getAllDoctors() {

        return new ArrayList<>(doctors.values());
    }
    @GetMapping("/doctors/status")
    public List<Employee> getDoctorsByStatus(@RequestParam Status status){
        ArrayList<Employee> employeesByStatus = new ArrayList<>();
        for(Employee e: doctors.values()){
            if(e.getStatus()==status){
                employeesByStatus.add(e);
            }
        }
        return  employeesByStatus;
    }
    @GetMapping("/doctors/id/{employee_id}")
    public Employee getDoctorById(@PathVariable int employee_id){
        return doctors.get(employee_id);
    }


    @GetMapping("/doctors/department/{department}")
    public List<Employee> getDoctorsByDepartment(@PathVariable String department){

        if(department == null) throw new NullPointerException("department is null");
        ArrayList<Employee> employees=new ArrayList<>();
        for(Employee e: doctors.values()){
            if(e.getDepartment().equals(department)){
                employees.add(e);
            }
        }
        return employees;
    }
}
