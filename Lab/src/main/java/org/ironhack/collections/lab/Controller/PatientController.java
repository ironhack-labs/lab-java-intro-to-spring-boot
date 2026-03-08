package org.ironhack.collections.lab.Controller;

import org.ironhack.collections.lab.Model.Patient;
import org.ironhack.collections.lab.Service.PatientService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public List<Patient> getPatients(){
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable int id){
        return patientService.getPatientById(id);
    }

    @GetMapping("/date-range")
    public List<Patient> getPatientsByDateRange(@RequestParam LocalDate start,
                                                @RequestParam LocalDate end){
        return patientService.getPatientsByDateRange(start, end);
    }

    @GetMapping("/patients-with-doctor-off")
    public List<Patient> getPatientsWithDoctorOff(){
        return patientService.getPatientsWithDoctorOff();
    }
    @GetMapping("/by-doctor-department")
    public List<Patient> getPatientsByDoctorDepartment(@RequestParam String department){
        return patientService.getPatientsByDoctorDepartment(department);
    }
}
