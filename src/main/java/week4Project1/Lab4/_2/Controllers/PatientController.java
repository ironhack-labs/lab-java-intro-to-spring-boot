package week4Project1.Lab4._2.Controllers;


import org.springframework.web.bind.annotation.*;
import week4Project1.Lab4._2.Models.Employee;
import week4Project1.Lab4._2.Models.Patient;
import week4Project1.Lab4._2.Repositories.EmployeeRepository;
import week4Project1.Lab4._2.Repositories.PatientRepository;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/patients")

public class PatientController {
    private final PatientRepository patientRepository;
    private final EmployeeRepository employeeRepository;

    public PatientController(PatientRepository patientRepository, EmployeeRepository employeeRepository) {
        this.patientRepository = patientRepository;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @GetMapping("/dob")
    public List<Patient> getPatientsByDateOfBirthRange(@RequestParam String startDate, @RequestParam String endDate) {
        return patientRepository.findByDateOfBirthBetween(startDate, endDate);
    }

    @GetMapping("/department/{department}")
    public List<Patient> getPatientsByDoctorDepartment(@PathVariable String department) {
                List<Employee> employees = employeeRepository.findByDepartment(department);
                List<Patient> patients = new ArrayList<>();
                for (Employee employee : employees) {
                    List<Patient> admittedPatients = patientRepository.AdmittedBy(employee);
                    patients.addAll(admittedPatients);

                }
                return patients;



    }
}

