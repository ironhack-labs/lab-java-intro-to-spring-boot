package Lab402.Controller.impl;

import Lab402.Repository.PatientRepository;
import Lab402.model.EmployeeStatus;
import Lab402.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PatientController {
    @Autowired
    PatientRepository patientRepository;

    @GetMapping("/patients")
    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }


    @GetMapping("/patients/{id}")
    public Patient getPatientById(@PathVariable Integer id){
    Optional<Patient> patientOptional = patientRepository.findById(id);
    if (patientOptional.isEmpty()) return null;
    return patientOptional.get();
    }

    @GetMapping("/patients/department/{department}")
    public List<Patient> getPatientsByDoctorDepartment(@PathVariable String department){
        return patientRepository.findAllPatientsByDoctorDepartment(department);
    }

    @GetMapping("/patients/doctorstatus/{employeeStatus}")
    public List<Patient> findAllPatientsByDoctorStatusOff(@PathVariable EmployeeStatus employeeStatus){
        return patientRepository.findAllPatientsByDoctorStatusOff(employeeStatus);
    }

}
