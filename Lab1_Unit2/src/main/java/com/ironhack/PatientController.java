package com.ironhack;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {


    //Get all patients: Create a route to get all patients.
    @GetMapping("/allPatients")
    public List<Patient> getName() {
        return new ArrayList<>(PatientRepository.patients.values());

    }

    //Get patient by ID: Create a route to get a patient by patient_id.
    @GetMapping("/patientsId")
    public List<Patient> getId() {
        return new ArrayList<>(PatientRepository.patients.values());

    }

    //Get patients by date of birth range: Create a route to get patients
    // date of birth within a specified range.
    @GetMapping("/patientsBirth")
    public List<Patient> getDate_of_birth() {
        List<Patient> result = new ArrayList<>();

        Patient[] patientsArray = PatientRepository.patients.values().toArray(new Patient[0]);
        Patient p = null;
        for (int i = 0; i < patientsArray.length; i++) {
            p = patientsArray[i];
        }
        String birthYearStr = p.getDate_of_birth().substring(0, 4);
        int birthYear = Integer.parseInt(birthYearStr);

        // between 1950 and 1980
        if (birthYear >= 1950 && birthYear <= 1980) {
            result.add(p);
        }
        return result;
    }

    //Get patients by admitting doctor's department: Create a route to get patients by
    // the department that their admitting doctor is in
    // (For example, get all patients admitted by a doctor in cardiology).

    // if employee id == admitted by,sout department ,patient name
    @GetMapping("/patientsDepartment")
    //ekstra sert lazimdi nece bilmedim
    public List<Patient> getAdmitted_by() {
        List<Patient> result = new ArrayList<>();

        Patient[] allPatients = PatientRepository.patients.values().toArray(new Patient[0]);
        Employee[] allEmployees = EmployeeRepository.employees.values().toArray(new Employee[0]);

        for (int i = 0; i < allPatients.length; i++) {
            Patient p = allPatients[i];
            // Looks for doctors
            for (int j = 0; j < allEmployees.length; j++) {
                Employee e = allEmployees[j];

                // idleri muqayise edir
                if (e.getEmployee_id() == p.getAdmitted_by()) {

                    if (e.getDepartment().equals("cardiology")) {
                        result.add(p);
                    }
                }
            }
        }
        return result;
    }

    //Get all patients with a doctor whose status is OFF:
    // Create a route to get all patients with a doctor whose status is OFF.


    @GetMapping("/patientsOff")
    public List<Patient> getPatientsHaveOffDoctors() {
        try {
            List<Patient> result = new ArrayList<>();
            //
            Patient[] allPatients = PatientRepository.patients.values().toArray(new Patient[0]);
            Employee[] allEmployees = EmployeeRepository.employees.values().toArray(new Employee[0]);
            for (int i = 0; i < allPatients.length; i++) {
                Patient p = allPatients[i];

                for (int j = 0; j < allEmployees.length; j++) {
                    Employee e = allEmployees[j];
                    if (e.getEmployee_id() == p.getAdmitted_by()) { //muqayise edir idlerini
                        if (e.getStatus().equals("OFF")) {
                            result.add(p);
                        }
                    }
                }
            }
            return result;
        } catch (Exception ex) {

            return new ArrayList<>();
        }
    }
}

