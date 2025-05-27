package com.example.MedicalCenter.Controller.implem;

import com.example.MedicalCenter.Model.EmployeeStatus;
import com.example.MedicalCenter.Model.Patient;
import com.example.MedicalCenter.Service.Interfaces.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/api")
public class PatientController {

    @Autowired
    IPatientService patientService;

    @GetMapping("/patients")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/patients/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }

    @GetMapping("/patients/birth-range")
    public List<Patient> getPatientsByBirthRange(
            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        return patientService.getPatientsByDateOfBirth(start, end);
    }

    @GetMapping("/patients/admitted-by/{doctorId}")
    public List<Patient> getPatientsByAdmittingDoctor(@PathVariable Long doctorId) {
        return patientService.getPatientsByAdmittingDoctorId(doctorId);
    }

    @GetMapping("/patients/department/{department}")
    public List<Patient> getPatientsByDoctorDepartment(@PathVariable String department) {
        return patientService.getPatientsByDoctorDepartment(department);
    }

    @GetMapping("/patients/doctors-off")
    public List<Patient> getPatientsByDoctorStatusOff() {
        return patientService.getPatientsByDoctorByStatusOff(EmployeeStatus.OFF);
    }

}


