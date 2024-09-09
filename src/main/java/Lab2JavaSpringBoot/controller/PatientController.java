package Lab2JavaSpringBoot.controller;

import Lab2JavaSpringBoot.enums.EmployeeStatus;
import Lab2JavaSpringBoot.model.Employee;
import Lab2JavaSpringBoot.model.Patient;
import Lab2JavaSpringBoot.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping
    public List<Patient> getAllPatients(){ return patientService.getAllPatients();}

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id){
        Optional<Patient> patients = patientService.getPatientById(id);
        return patients.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }
    @GetMapping("/search/BirthDateRange")
    public List<Patient> searchByBirthDateRange(
            @RequestParam("startDate") LocalDate startDate,
            @RequestParam("endDate") LocalDate endDate
    ){
        return patientService.searchByBirthDateRange(startDate, endDate);
    }

    //lista de medicos con sus pacientes
    @GetMapping("/search/patientAdmittedBy")
    public List<Patient> searchPatientAdmitted(@RequestBody Employee admittedBy){
        List<Patient> patients = patientService.getPatientByAdmittedBy(admittedBy);
        return patients;
    }

    //saco los pacientes de los medicos segun su departamento, porque estoy en list y le paso departamento de los medicos
    @GetMapping("/search/patientByDepartment")
    public List<Patient> searchByDepartment(@RequestParam String department) {
        return patientService.getPatientByDepartment(department);
    }

    //Obtengo todos los pacientes con un médico cuyo estado esté DESACTIVADO: crea una ruta para obtener todos los pacientes
    // con un médico cuyo statusestado esté DESACTIVADO.
    @GetMapping("/search/patientByDoctorStatus")
    public List<Patient> searchPatientByDoctorStatus(@RequestParam EmployeeStatus status) {
        return patientService.getPatientByDoctorStatus(status);
    }

}

