package com.example.demo.controller;

import com.example.demo.Employee;
import com.example.demo.Patient;
import com.example.demo.Status;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class PatientController {
    HashMap<Integer, Patient> patients=new HashMap<>();
    HashMap<Integer, Employee> doctors=new HashMap<>();

    public PatientController() {
        patients.put(1, new Patient(1,"Jaime Jordan", "1984-03-02",761527));
        patients.put(2, new Patient(2,"Marian Garcia", "1972-01-12",761527));
        patients.put(3, new Patient(3,"Julia Dusterdieck", "1954-06-11", 356712));
        patients.put(4, new Patient(4,"Steve McDuck", "1931-11-10", 761527));
        patients.put(5, new Patient(5,"Marian Garcia", "1999-02-15", 172456));

        doctors.put(356712, new Employee(356712,"cardiology", "Alonso Flores", Status.ON_CALL));
        doctors.put(564134, new Employee(564134,"immunology", "Sam Ortega", Status.ON));
        doctors.put(761527, new Employee(761527,"cardiology", "German Ruiz", Status.OFF));
        doctors.put(166552, new Employee(166552,"pulmonary", "Maria Lin", Status.ON));
        doctors.put(156545, new Employee(156545,"orthopaedic", "Paolo Rodriguez", Status.ON_CALL));
        doctors.put(172456, new Employee(172456,"psychiatric", "John Paul Armes", Status.OFF));
    }

    @GetMapping("/patients")
    public List<Patient> getAllPatients(){
        return new ArrayList<>(patients.values());
    }
    @GetMapping("/patients/patient_id/{id}")
    public Patient getPatientById(@PathVariable int id){
        return patients.get(id);
    }
    @GetMapping("/patients/date_of_birth")
    public List<Patient> getPatientsSpecificRange(@RequestParam String start,@RequestParam String end){
        ArrayList<Patient> rangedPatients=new ArrayList<>();
        LocalDate startDate=LocalDate.parse(start);
        LocalDate endDate=LocalDate.parse(end);

        if(startDate.isAfter(endDate)){
            throw new IllegalArgumentException("Start date should be after end date");
        }

        for(Patient p:patients.values()){
            LocalDate patientDate=LocalDate.parse(p.getDate_of_birth());

            if(!patientDate.isBefore(startDate) && !patientDate.isAfter(endDate)){
                rangedPatients.add(p);
            }
        }
        return rangedPatients;
    }
    @GetMapping("/patients/doctors_department/{doctors_department}")
    public List<Patient> getPatientsByDoctorsDepartment(@PathVariable String doctors_department){
        ArrayList<Patient> patientsByDoctorsDepartment=new ArrayList<>();
        for(Employee doctor:doctors.values()){
            if(doctor.getDepartment().equals(doctors_department)){
                for(Patient patient:patients.values()){
                    if(patient.getAdmitted_by()==doctor.getId()){
                        patientsByDoctorsDepartment.add(patient);
                    }
                }
            }
        }

        return  patientsByDoctorsDepartment;
    }

    @GetMapping("/patients/doctors_status/OFF")
    public List<Patient> getPatientsByDoctorsStatus(){

        ArrayList<Employee> doctorStatusOff=new ArrayList<>();
        ArrayList<Patient> patientsWithDoctorStatusOff=new ArrayList<>();

        for(Employee doctor:doctors.values()){
            if(doctor.getStatus()==Status.OFF){
                doctorStatusOff.add(doctor);
            }
        }
        for(Patient patient:patients.values()){
            for(Employee doctor:doctorStatusOff){
                if(patient.getAdmitted_by()==doctor.getId()){
                    patientsWithDoctorStatusOff.add(patient);
                }
            }
        }
        return  patientsWithDoctorStatusOff;
    }

}
