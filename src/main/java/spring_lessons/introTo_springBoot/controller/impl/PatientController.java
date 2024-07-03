package spring_lessons.introTo_springBoot.controller.impl;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring_lessons.introTo_springBoot.model.Employee;
import spring_lessons.introTo_springBoot.model.Patient;
import spring_lessons.introTo_springBoot.repository.EmployeeRepository;
import spring_lessons.introTo_springBoot.repository.PatientRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PatientController {
    @Autowired
    PatientRepository patientRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/patients")
    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }

    @GetMapping("/patient/{id}")
    public Patient getPatientById(@PathVariable Integer id){
        Optional<Patient> patientOptional = patientRepository.findById(id);
        return patientOptional.orElse(null);
    }

    @GetMapping("/patients/by-birthdate-range")
    public List<Patient> getPatientsByDateOfBirthRange(
            @RequestParam("start") String start,
            @RequestParam("end") String end
    ){
        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);
        return patientRepository.findByDateOfBirthBetween(startDate, endDate);
    }

    @GetMapping("/patients/department")
    public List<Patient> getPatientsByDepartment(@RequestParam String department){
        return patientRepository.findAllWhereDepartmentIs(department);
    }

    @GetMapping("/patients/by-doctor-status-off")
    public List<Patient> getPatientsByDoctorStatusOff(){
        return patientRepository.findAllWhereDoctorStatusIsOff();
    }


}
