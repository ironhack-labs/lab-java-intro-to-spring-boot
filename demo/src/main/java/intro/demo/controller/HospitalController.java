package intro.demo.controller;
import intro.demo.model.*;
import intro.demo.repositories.*;
import intro.demo.services.EmployeeService;
import intro.demo.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class HospitalController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PatientService patientService;

    // Get all doctors
    @GetMapping("/doctors")
    public List<Employee> getAllDoctors() {
        return employeeService.getAllDoctors();
    }

    // Get doctor by ID
    @GetMapping("/doctors/{employeeId}")
    public Employee getDoctorById(@PathVariable Long employeeId) {
        try {
            return employeeService.getDoctorById(employeeId);
        } catch (ChangeSetPersister.NotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // Get doctors by status
    @GetMapping("/doctors/status/{status}")
    public List<Employee> getDoctorsByStatus(@PathVariable String status) {
        return employeeService.getDoctorsByStatus(status);
    }

    // Get doctors by department
    @GetMapping("/doctors/department/{department}")
    public List<Employee> getDoctorsByDepartment(@PathVariable String department) {
        return employeeService.getDoctorsByDepartment(department);
    }

    // Get all patients
    @GetMapping("/patients")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    // Get patient by ID
    @GetMapping("/patients/{patientId}")
    public Patient getPatientById(@PathVariable Long patientId) {
        return patientService.getPatientById(patientId);
    }

    // Get patients by date of birth range
    @GetMapping("/patients/dob")
    public List<Patient> getPatientsByDateOfBirthRange(@RequestParam("start") String startDate,
                                                       @RequestParam("end") String endDate) {
        return patientService.getPatientsByDateOfBirthRange(startDate, endDate);
    }

    // Get patients by admitting doctor's department
    @GetMapping("/patients/department/{department}")
    public List<Patient> getPatientsByAdmittingDoctorsDepartment(@PathVariable String department) {
        return patientService.getPatientsByAdmittingDoctorsDepartment(department);
    }

    // Get all patients with a doctor whose status is OFF
    @GetMapping("/patients/doctors/off")
    public List<Patient> getPatientsWithDoctorsStatusOFF() {
        return patientService.getPatientsWithDoctorsStatusOFF();
    }
}

