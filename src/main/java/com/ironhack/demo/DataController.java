package com.ironhack.demo;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@RestController
public class DataController {
    @RequestMapping(value = "/doctors", method = RequestMethod.GET)
    public List<Doctors> getAllDoctors() {
        return DataStore.doctors.values().stream().toList();
    }
    @GetMapping("/doctors/{employeeId}")
    public Doctors getDoctorById(@PathVariable Long employeeId) {
        return DataStore.doctors.get(employeeId);
    }
    @GetMapping("/doctors/status/{status}")
    public List<Doctors> getDoctorsByStatus(@PathVariable Status status) {
        return DataStore.doctors.values().stream()
                .filter(e -> e.getStatus() == status)
                .toList();
    }
    @GetMapping("/doctors/department/{department}")
    public List<Doctors> getDoctorsByDepartment(@PathVariable String department) {
        return DataStore.doctors.values().stream()
                .filter(e -> e.getDepartmentl().equalsIgnoreCase(department))
                .toList();
    }

    @RequestMapping(value = "/patients", method =RequestMethod.GET)
    public List<Patient> getAllPatients(){
        return DataStore.patients.values().stream().toList();
    }
    @GetMapping("/patients/{patientId}")
    public Patient getPatientById(@PathVariable Long patientId) {
        return DataStore.patients.get(patientId);
    }
    @GetMapping("/patients/dob")
    public List<Patient> getPatientsByDobRange(
            @RequestParam LocalDate start,
            @RequestParam LocalDate end) {

        return DataStore.patients.values().stream()
                .filter(p -> !p.getDateOfBirth().isBefore(start)
                        && !p.getDateOfBirth().isAfter(end))
                .toList();
    }
    @GetMapping("/patients/doctor-department/{department}")
    public List<Patient> getPatientsByDoctorDepartment(@PathVariable String department) {

        return DataStore.patients.values().stream()
                .filter(p -> {
                    Doctors doc = DataStore.doctors.get(p.getAdmitted_by());
                    return doc != null &&
                            doc.getDepartmentl().equalsIgnoreCase(department);
                })
                .toList();
    }
    @GetMapping("/patients/doctor-status/{status}")
    public List<Patient> getPatientsByDoctorStatus(@PathVariable Status status) {

        return DataStore.patients.values().stream()
                .filter(p -> {
                    Doctors doc = DataStore.doctors.get(p.getAdmitted_by());
                    return doc != null &&
                            doc.getStatus() == status;
                })
                .toList();
    }


}
