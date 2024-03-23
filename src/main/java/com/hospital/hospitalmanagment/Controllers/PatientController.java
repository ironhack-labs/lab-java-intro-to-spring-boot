package com.hospital.hospitalmanagment.Controllers;

import com.hospital.hospitalmanagment.Services.EmployeeService;
import com.hospital.hospitalmanagment.Services.PatientService;
import com.hospital.hospitalmanagment.model.Employee;
import com.hospital.hospitalmanagment.model.Patient;

import com.hospital.hospitalmanagment.model.Status;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientService patientsService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getAllPatients(){
        return patientsService.getAllPatients();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Patient> getPatientById(@PathVariable int id){
        Optional<Patient> patient = patientsService.getPatientById(id);
        return patient.map(value -> ResponseEntity.ok().body(value)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("get-by-birthday")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Patient>> getPatientsByBirthRange(@RequestParam Date start, @RequestParam Date finish){
        List<Patient> patients = patientsService.getPatientByBirthRange(start,finish);
        return patients.isEmpty()? ResponseEntity.notFound().build() : ResponseEntity.ok().body(patients);

    }

    @GetMapping("/get-by-department")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Patient>> getPatientsByDoctorsDepartment(@RequestParam String department){
        List<Patient> patients = patientsService.getPatientByDoctorsDepartment(department);
        return patients.isEmpty()? ResponseEntity.notFound().build() : ResponseEntity.ok().body(patients);

    }

    @GetMapping("/get-by-doctor-status/{status}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Patient>> getPatientsByDoctorsStatus(@PathVariable Status status){
        List<Patient> patients = patientsService.getPatientByDoctorsStatus(status);
        return patients.isEmpty()? ResponseEntity.notFound().build() : ResponseEntity.ok().body(patients);

    }



}
