package com.ironhack.springboottask.Controllers;

import com.ironhack.springboottask.Entity.Employee;
import com.ironhack.springboottask.Entity.Patient;
import com.ironhack.springboottask.Repositories.HospitalRepository;
import com.ironhack.springboottask.enums.Status;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class HospitalController {

    private final HospitalRepository repo;

    public HospitalController(HospitalRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/api/doctors")
    public List<Employee> getAllDoctors(){
        return new ArrayList<Employee>(repo.employees.values());
    }

    @GetMapping("/api/doctors/{id}")
    public Employee getDoctorById(@PathVariable int id){
        return repo.employees.get(id);
    }

    @GetMapping("/api/doctors/status/{status}")
    public List<Employee> getDoctorsByStatus(@PathVariable Status status){

        List<Employee> result = new ArrayList<>();

        for(Employee e : repo.employees.values()){
            if(e.getStatus() == status){
                result.add(e);
            }
        }

        return result;
    }

    @GetMapping("/api/doctors/department/{department}")
    public List<Employee> getDoctorsByStatus(@PathVariable String department){

        List<Employee> result = new ArrayList<>();

        for(Employee e : repo.employees.values()){
            if(Objects.equals(e.getDepartment(), department)){
                result.add(e);
            }
        }

        return result;
    }

    @GetMapping("/api/patients")
    public List<Patient> getAllPatients(){
        return new ArrayList<Patient>(repo.patients.values());
    }

    @GetMapping("api/patients/{patient_id}")
    public Patient getPatientById(@PathVariable int patient_id){
        return repo.patients.get(patient_id);
    }

    @GetMapping("api/patients/dob")
    public List<Patient> getPatientsByDob(@RequestParam String start, @RequestParam String end){
        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);

        List<Patient> result = new ArrayList<>();

        for (Patient p : repo.patients.values()){
            if (!p.getDateOfBirth().isBefore(startDate) && !p.getDateOfBirth().isAfter(endDate)){
                result.add(p);
            }
        }

        return result;
    }

    @GetMapping("/api/patients/department/{department}")
    public List<Patient> getPatientsByDoctorDepartment(@PathVariable String department){

        List<Patient> result = new ArrayList<>();

        for(Patient p : repo.patients.values()){
            Employee doctor = repo.employees.get(p.getAdmittedBy());

            if(doctor != null &&
                    doctor.getDepartment().equalsIgnoreCase(department)){
                result.add(p);
            }
        }

        return result;
    }

    @GetMapping("/api/patients/doctor-status/OFF")
    public List<Patient> getPatientsWithDoctorStatusOff(){

        List<Patient> result = new ArrayList<>();

        for(Patient p : repo.patients.values()){
            Employee doctor = repo.employees.get(p.getAdmittedBy());

            if(doctor != null &&
                    doctor.getStatus() == Status.OFF){
                result.add(p);
            }
        }

        return result;
    }

}
