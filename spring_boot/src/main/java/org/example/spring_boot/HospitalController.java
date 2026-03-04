package org.example.spring_boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HospitalController {
    @Autowired
    private EmployeeRepository employeeRepo;
    @Autowired
    private PatientRepository patientRepo;

    @GetMapping("/doctors")
    public List<Employee> getAllDoctors(){
       return employeeRepo.findAll();
    }

    @GetMapping("/doctors/{id}")
    public Employee employee(@PathVariable Long id){
        return employeeRepo.findById(id).orElse(null);
    }
    @GetMapping("/doctors/status/{status}")
    public List<Employee> getDoctorsByStatus(@PathVariable String status){
        return employeeRepo.findByStatus(status);
    }

    @GetMapping("/doctors/department/{department}")
    public List<Employee> getDoctorsByDepartments(@PathVariable String department){
        return employeeRepo.findByDepartment(department);
    }

    @GetMapping("/patients/search")
    public List<Patient> getPatientsByBirthDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
                                                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end){
        return patientRepo.findByDateOfBirthBetween(start,end);
    }

    @GetMapping("/patients/department/{department}")
    public List <Patient> getPatientsByDoctorDepartment(@PathVariable String department){
        return patientRepo.findByAdmittedByDepartment(department);
    }
    @GetMapping("/patients/doctors-off")
    public List<Patient> getPatientsWithDoctorOff(){
        return patientRepo.findByAdmittedByStatus("OFF");
    }
    @GetMapping("/patients")
    public List<Patient> getAllPatients() {
        return patientRepo.findAll();
    }
    @GetMapping("/patients/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientRepo.findById(id).orElse(null);
    }
}
