package com.ironhack.springboot.controller;

import com.ironhack.springboot.model.Employee;
import com.ironhack.springboot.model.Patient;
import com.ironhack.springboot.service.EmployeeService;
import com.ironhack.springboot.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Hospital")
@RequiredArgsConstructor
public class HospitalController {

//    Get all patients with a doctor whose status is OFF: Create a route to get all patients with a doctor whose status is OFF.

    private final EmployeeService employeeService;
    private final PatientService patientService;

    //    Get all doctors: Create a route to get all doctors.
    @GetMapping("/Employees")
    public List<Employee> getAllDoctors() {
        return employeeService.getAllEmployees();
    }

    //    Get doctor by ID: Create a route to get a doctor by employee_id.
    @GetMapping("/Employees/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable("id") Long id) {
        return employeeService.getEmployeeById(id);
    }


    //    Get doctors by status: Create a route to get doctors by status.
    @GetMapping("/Employees/status/{status}")
    public List<Employee> getEmployeesByStatus(@PathVariable("status") String status) {
        return employeeService.getEmployeesByStatus(status);
    }

    //    Get doctors by department: Create a route to get doctors by department.
    @GetMapping("/Employees/department/{department}")
    public List<Employee> getEmployeesByDepartment(@PathVariable("department") String department) {
        return employeeService.getEmployeesByDepartment(department);
    }

    //    Get all patients: Create a route to get all patients.
    @GetMapping("/Patients")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    //    Get patient by ID: Create a route to get a patient by patient_id.
    @GetMapping("/Patients/{id}")
    public Optional<Patient> getPatientById(@PathVariable("id") Long id) {
        return patientService.getPatientById(id);
    }

    //    Get patients by date of birth range: Create a route to get patients date of birth within a specified range.
    @GetMapping("/Patients/dateOfBirth/{dateOfBirthStart}/{dateOfBirthEnd}")
    public List<Patient> getPatientsByDateOfBirth(@PathVariable("dateOfBirthStart") String dateOfBirthStart, @PathVariable("dateOfBirthEnd") String dateOfBirthEnd) {
        return patientService.getPatientsByDateOfBirthRange(dateOfBirthStart, dateOfBirthEnd);
    }

    //    Get patients by admitting doctor's department: Create a route to get patients by the department that their admitting doctor is in (For example, get all patients admitted by a doctor in cardiology).
    @GetMapping("/Patients/admittingDoctorDepartment/{department}")
    public List<Patient> getPatientsByAdmittingDoctorDepartment(@PathVariable("department") String department) {
        return patientService.getPatientsByAdmittingDoctorDepartment(department);
    }

    //    Get all patients with a doctor whose status is OFF: Create a route to get all patients with a doctor whose status is OFF.
    @GetMapping("/Patients/statusOff")
    public List<Patient> getPatientsWithStatusOff() {
        return patientService.getPatientsWithDoctorOff();
    }




}
