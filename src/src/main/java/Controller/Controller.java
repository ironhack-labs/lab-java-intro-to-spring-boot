package Controller;

import Model.Employee;
import Model.Patient;
import Service.EmployeeService;
import Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private PatientService patientService;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/patients/{patientId}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long patientId) {
        Patient patient = patientService.getPatientById(patientId);
        return ResponseEntity.ok().body(patient);
    }

    @GetMapping("/patients/dob")
    public List<Patient> getPatientsByDateOfBirthRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return patientService.getPatientsByDateOfBirthRange(startDate, endDate);
    }

    @GetMapping("/patients/department/{department}")
    public List<Patient> getPatientsByAdmittingDoctorsDepartment(@PathVariable String department) {
        return patientService.getPatientsByAdmittingDoctorsDepartment(department);
    }

    @GetMapping("/patients/doctors/status/OFF")
    public List<Patient> getPatientsWithDoctorsInStatusOff() {
        return patientService.getPatientsWithDoctorsInStatusOff();
    }
    @GetMapping
    public List<Employee> getAllDoctors() {
        return employeeService.getAllDoctors();
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<Employee> getDoctorById(@PathVariable Long employeeId) {
        Employee doctor = employeeService.getDoctorById(employeeId);
        return ResponseEntity.ok().body(doctor);
    }

    @GetMapping("/employee/status/{status}")
    public List<Employee> getDoctorsByStatus(@PathVariable String status) {
        return employeeService.getDoctorsByStatus(status);
    }

    @GetMapping("/employee/department/{department}")
    public List<Employee> getDoctorsByDepartment(@PathVariable String department) {
        return employeeService.getDoctorsByDepartment(department);
    }

}

