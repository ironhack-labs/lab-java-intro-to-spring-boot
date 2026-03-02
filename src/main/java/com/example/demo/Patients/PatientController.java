package com.example.demo.Patients;

import com.example.demo.Employees.Employee;
import com.example.demo.Employees.EmployeeStatus;
import com.example.demo.Seed;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@RestController
public class PatientController {
    @GetMapping("/patients")
    public Collection<Patient> getAllPatients() {
        return Seed.patients.values();
    }

    @GetMapping("/patients/{id}")
    public Patient getPatientById(@PathVariable String id) {
        return Seed.patients.get(id);
    }

    @GetMapping("/patients/department/{department}")
    public List<Patient> getPatientsByDoctorDepartment(@PathVariable String department) {
        List<Patient> result = new ArrayList<>();
        for (Patient p : Seed.patients.values()) {
            Employee doctor = Seed.employees.get(p.getAdmittedBy());
            if (doctor != null && doctor.getDepartment().equalsIgnoreCase(department)) {
                result.add(p);
            }
        }
        return result;
    }

    @GetMapping("/patients/dob")
    public List<Patient> getPatientsByBirthRange(@RequestParam @DateTimeFormat(pattern = "yyyy-mm-dd") Date fromDate, @RequestParam @DateTimeFormat(pattern = "yyyy-mm-dd") Date toDate) {
        List<Patient> patients = new ArrayList<>();
        for (Patient patient : Seed.patients.values()) {
            Date dob = patient.getDateOfBirth();
            if (!dob.before(fromDate) && !dob.after(toDate)) {
                patients.add(patient);
            }
        }
        return patients;
    }

    @GetMapping("/patients/doctor/off")
    public List<Patient> getPatientsWithDoctorOff() {
        List<Patient> result = new ArrayList<>();
        for (Patient p : Seed.patients.values()) {
            Employee doctor = Seed.employees.get(p.getAdmittedBy());
            if (doctor != null && doctor.getStatus() == EmployeeStatus.OFF) {
                result.add(p);
            }
        }
        return result;
    }

}
