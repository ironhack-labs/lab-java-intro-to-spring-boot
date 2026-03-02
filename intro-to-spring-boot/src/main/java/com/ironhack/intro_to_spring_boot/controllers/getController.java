package com.ironhack.intro_to_spring_boot.controllers;

import com.ironhack.intro_to_spring_boot.database.AllEmployeesAndPatients;
import com.ironhack.intro_to_spring_boot.entities.Employee;
import com.ironhack.intro_to_spring_boot.entities.Patient;
import com.ironhack.intro_to_spring_boot.enums.Status;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@RestController
@RequestMapping("/api/hospital")
public class getController {
    private AllEmployeesAndPatients allEmployeesAndPatients = new AllEmployeesAndPatients();
    public getController(AllEmployeesAndPatients allEmployeesAndPatients){
        this.allEmployeesAndPatients = allEmployeesAndPatients;
    }

    @GetMapping("/doctors")
    public List<Employee> getAllDoctors(){
        return new ArrayList<>(allEmployeesAndPatients.employees.values());
    }

    @GetMapping("/doctors/id/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return allEmployeesAndPatients.employees.get(id);
    }

    @GetMapping("/doctors/status/{status}")
    public List<Employee> getEmployeesByStatus(@PathVariable Status status){
        List<Employee> employeeList = new ArrayList<>();

        for(Employee employee : allEmployeesAndPatients.employees.values()){
            if (employee.getStatus() == status){
                employeeList.add(employee);
            }
        }
        return employeeList;
    }

    @GetMapping("/doctors/department/{department}")
    public List<Employee> getEmployeesByDepartment(@PathVariable String department){
        List<Employee> employeeList = new ArrayList<>();

        for(Employee employee : allEmployeesAndPatients.employees.values()){
            if (department.equals(employee.getDepartment())){
                employeeList.add(employee);
            }
        }
        return employeeList;
    }

    @GetMapping("/patients")
    public List<Patient> getAllPatients(){
        return new ArrayList<>(allEmployeesAndPatients.patients.values());
    }

    @GetMapping("/patients/id/{id}")
    public Patient getPatientById(@PathVariable Long id){
        return allEmployeesAndPatients.patients.get(id);
    }

    @GetMapping("/patients/dataRange/{start}&{end}")
    public List<Patient> getPatientsByDateRange(
            @PathVariable String start,
            @PathVariable String end) {

        List<Patient> patientList = new ArrayList<>();

        for (Patient patient : allEmployeesAndPatients.patients.values()) {

            if (patient.getDateOfBirth().compareTo(start) >= 0 &&
                    patient.getDateOfBirth().compareTo(end) <= 0) {

                patientList.add(patient);
            }
        }

        return patientList;
    }

    @GetMapping("/patients/department/{department}")
    public List<Patient> getPatientsByDateRange(
            @PathVariable String department) {

        List<Patient> patientList = new ArrayList<>();

        for (Patient patient : allEmployeesAndPatients.patients.values()) {
            Employee doctor = allEmployeesAndPatients.employees.get(patient.getAdmittedBy());
            if(doctor != null && doctor.getDepartment().equals(department)){
                patientList.add(patient);
            }
        }

        return patientList;
    }

    @GetMapping("/patients/status/{status}")
    public List<Patient> getPatientsByStatus(
            @PathVariable Status status) {

        List<Patient> patientList = new ArrayList<>();

        for (Patient patient : allEmployeesAndPatients.patients.values()) {
            Employee doctor = allEmployeesAndPatients.employees.get(patient.getAdmittedBy());
            if(doctor != null && doctor.getStatus() == status){
                patientList.add(patient);
            }
        }

        return patientList;
    }
}
