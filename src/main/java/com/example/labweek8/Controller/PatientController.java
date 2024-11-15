package com.example.labweek8.Controller;

import com.example.labweek8.Model.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/patients")
@RequiredArgsConstructor
public class PatientControllerImpl implements PatientControllerInterface {

    private final PatientService patientService;

    @Override
    @GetMapping("all")
    public List<Patient> getPatients() {
        return patientService.getAllPatients();
    }

    @Override
    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable(name = "id") int id) {
        return patientService.getPatientById(id);
    }



    @Override
    @GetMapping("doctor")
    public List<Patient> getPatientsByDoctorDepartment(@RequestParam String department) {
        return patientService.getPatientByDoctorDepartment(department);
    }

    @Override
    @GetMapping("withDoctorOff")
    public List<Patient> getPatientsWithDoctorStatusOff() {
        return patientService.getPatientByDoctorStatus(EmployeeStatus.OFF);
    }


}