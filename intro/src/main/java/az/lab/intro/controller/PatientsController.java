package az.lab.intro.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import az.lab.intro.entity.Employee;
import az.lab.intro.entity.EmployeeEntity;
import az.lab.intro.entity.Patient;
import az.lab.intro.entity.PatientEntity;

@RestController
@RequestMapping("/patients")
public class PatientsController {

    Patient patients = new Patient();
    Employee employees = new Employee();

    // 5. Get all patients: Create a route to get all patients.
    @GetMapping("all-patients")
    public List<Map.Entry<Integer, PatientEntity>> getAllPatients() {

        return new ArrayList<>(patients.patients.entrySet());
    }

    //6. Get patient by ID: Create a route to get a patient by patient_id.
     @GetMapping("get-by-id/{id}")
    public PatientEntity getPatientById(@PathVariable int id){


        return patients.getPatients().get(id);
    }

    // 7. Get patients by date of birth range: Create a route to get 
    // patients date of birth within a specified range.
    // private Date dateOfBirth;
    @GetMapping("get-by-date-range")
    public List<Map<Integer, PatientEntity>> getByBirthDate(@RequestParam Date begins, @RequestParam Date ends){

        List<Map<Integer, PatientEntity>> filtered = new ArrayList<>();

        patients.getPatients().forEach((id, patient) -> {

                    if(patient.getDateOfBirth().after(begins)&& patient.getDateOfBirth().before(ends)){
                        Map<Integer, PatientEntity> map = new HashMap<>();
                        map.put(id, patient);
                        filtered.add(map);
                    }
        });

        return filtered;
        
    }


    // 8. Get patients by admitting doctor's department: Create a route to get
    // patients by the department that their admitting doctor is in 
    // (For example, get all patients admitted by a doctor in cardiology).
    @GetMapping("get-doctors-patients/{department}")
    public List<Map<Integer, PatientEntity>> getDoctorsPatients(@PathVariable String department){


        List<Map<Integer, PatientEntity>> filtered = new ArrayList<>();

        List<Integer> doctorId = new ArrayList<>();
        
        employees.getEmployees().forEach((id, employee) -> {

                    if(employee.getDepartment().equalsIgnoreCase(department)){

                        doctorId.add(id);
                    }
        });

        patients.getPatients().forEach((id, patient)-> {

            if(doctorId.contains(patient.getAdmittedBy())){
                
                Map<Integer, PatientEntity> map = new HashMap<>();
                map.put(id, patient);
                filtered.add(map);
            }


        });


        return filtered;



    }



    // Get all patients with a doctor whose status is OFF: Create a route to get 
    // all patients with a doctor whose status is OFF.

    @GetMapping("get-doctors-patients/{status}")
    public List<Map<Integer, PatientEntity>> getPatientsByStatus(@PathVariable String status){


        List<Map<Integer, PatientEntity>> filtered = new ArrayList<>();

        List<Integer> doctorStatus = new ArrayList<>();
        
        employees.getEmployees().forEach((id, employee) -> {

                    if(employee.getStatus().equalsIgnoreCase(status)){

                        doctorStatus.add(id);
                    }
        });

        patients.getPatients().forEach((id, patient)-> {

            if(doctorStatus.contains(patient.getAdmittedBy())){
                
                Map<Integer, PatientEntity> map = new HashMap<>();
                map.put(id, patient);
                filtered.add(map);
            }


        });


        return filtered;



    }


}
