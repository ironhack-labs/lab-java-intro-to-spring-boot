package com.ironhack.lab_springboot.controller;

import com.ironhack.lab_springboot.Doctor;
import com.ironhack.lab_springboot.Patient;
import com.ironhack.lab_springboot.Status;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.ironhack.lab_springboot.Status.*;
import static java.util.stream.Collectors.toList;

@RestController
public class HospitalController {
    private HashMap<Integer, Doctor> doctors = new HashMap<>();
    private HashMap<Integer, Patient> patients = new HashMap<>();
    private ArrayList<Doctor> doctorsList;
    private ArrayList<Patient> patientsList;

    public HospitalController(){
        doctors.put(356712, new Doctor(356712, "cardiology", "Alonso Flores", ON_CALL));
        doctors.put(564134, new Doctor(564134, "immunology", "Sam Ortega", ON));
        doctors.put(761527, new Doctor(761527, "cardiology", "German Ruiz", OFF));
        doctors.put(166552, new Doctor(166552, "pulmonary", "Maria Lin", ON));
        doctors.put(156545, new Doctor(156545, "orthopaedic", "Paolo Rodriguez", ON_CALL));
        doctors.put(172456, new Doctor(172456, "psychiatric", "John Paul Armes", OFF));


        patients.put(1, new Patient("1984-03-02", 564134, "Jaime Jordan", 1));
        patients.put(2, new Patient("1972-01-12", 564134, "Marian Garcia", 2));
        patients.put(3, new Patient("1954-06-11", 356712, "Julia Dusterdieck", 3));
        patients.put(4, new Patient("1931-11-10", 761527, "Steve McDuck", 4));
        patients.put(5, new Patient("1999-02-15", 172456, "Marian Garcia", 5));

        doctorsList = new ArrayList<>(doctors.values());
        patientsList = new ArrayList<>(patients.values());
    }

    @GetMapping("/doctors")
    public List<Doctor> getAllDoctors(){
        return new ArrayList<>(doctors.values());
    }

    @GetMapping("/doctors/{id}")
    public Doctor getDoctorById(@PathVariable int id){
        return doctors.get(id);
    }

    @GetMapping("/doctors/status/{status}")
    public List<Doctor> getDoctorByStatus(@PathVariable String status){
        return doctors.values().stream().filter(d -> d.getStatus().toString().equals(status)).toList();
    }

    @GetMapping("/doctors/departments/{department}")
    public List<Doctor> getDoctorByDepartment(@PathVariable String department){
        return doctors.values().stream().filter(d -> d.getDepartment().equals(department)).toList();
    }



    @GetMapping("/patients")
    public List<Patient> getAllPatients(){
        return patients.values().stream().toList();
    }

    @GetMapping("/patients/{id}")
    public Patient getPatientById(@PathVariable int id){
        return patients.get(id);
    }

    @GetMapping("/patients/date_of_birth")
    public List<Patient> getPatientsByDateRange(@RequestParam String startDate, @RequestParam String endDate){
        return patients.values().stream().filter(p -> p.getDate_of_birth().compareTo(startDate) >= 0 && p.getDate_of_birth().compareTo(endDate) <= 0).toList();
    }

    @GetMapping("/patients/by-department")
    public List<Patient> getPatientsByDepartment(@RequestParam String department) {

        List<Integer> doctorIds = new ArrayList<>();
        for (Doctor d : doctorsList) {
            if (d.getDepartment().trim().equalsIgnoreCase(department.trim())) {
                doctorIds.add(d.getEmployee_id());
            }
        }

        List<Patient> result = new ArrayList<>();
        for (Patient p : patientsList) {
            if (doctorIds.contains(p.getAdmitted_by())) {
                result.add(p);
            }
        }

        return result;
    }

    @GetMapping("/patients/by-status-off")
    public List<Patient> getPatientsWithOffDoctors(){
        ArrayList<Patient> result = new ArrayList<>();
        for(Doctor d : doctorsList){
            if(d.getStatus() == OFF){
                for(Patient p : patientsList){
                    if(p.getAdmitted_by() == d.getEmployee_id()){
                        result.add(p);
                    }
                }
            }
        }
        return result;
    }

}
