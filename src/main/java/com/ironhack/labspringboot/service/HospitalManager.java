package com.ironhack.labspringboot.service;

import com.ironhack.labspringboot.entity.Employee;
import com.ironhack.labspringboot.entity.Patient;
import com.ironhack.labspringboot.enums.Status;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HospitalManager {


    private final Map<Integer, Employee> employees = new HashMap<>();
    private final Map<Integer, Patient> patients = new HashMap<>();


    public HospitalManager() {
        employees.put(356712, new Employee(356712, "cardiology", "Alonso Flores", Status.ON_CALL));
        employees.put(564134, new Employee(564134, "immunology", "Sam Ortega", Status.ON));
        employees.put(761527, new Employee(761527, "cardiology", "German Ruiz", Status.OFF));
        employees.put(166552, new Employee(166552, "pulmonary", "Maria Lin", Status.ON));
        employees.put(156545, new Employee(156545, "orthopaedic", "Paolo Rodriguez", Status.ON_CALL));
        employees.put(172456, new Employee(172456, "psychiatric", "John Paul Armes", Status.OFF));


        patients.put(1, new Patient(1, "Jaime Jordan", LocalDate.parse("1984-03-02"), 564134));
        patients.put(2, new Patient(654321, "Marian Garcia", LocalDate.parse("1972-01-12"), 564134));
        patients.put(3, new Patient(789012, "Julia Dusterdieck", LocalDate.parse("1954-06-11"), 356712));
        patients.put(4, new Patient(345678, "Steve McDuck", LocalDate.parse("1931-11-10"), 761527));
        patients.put(5, new Patient(901234, "Marian Garcia", LocalDate.parse("1999-02-15"), 172456));
    }


    public List<Employee> getAllDoctors() {
        return new ArrayList<>(employees.values());
    }

    public Employee getDoctorByID( int id ) {
        return employees.get(id);
    }

    public List<Employee> getDoctorByStatus( Status status ) {
        List<Employee> doctors = new ArrayList<>();
        for (Employee employee : employees.values()) {
            if (employee.getStatus() == status) {
                doctors.add(employee);
            }
        }
        return doctors;


    }

    public List<Employee> getDoctorByDepartment( String department ) {
        List<Employee> doctors = new ArrayList<>();
        for (Employee employee : employees.values()) {
            if (employee.getDepartment().equalsIgnoreCase(department)) {
                doctors.add(employee);
            }
        }
        return doctors;
    }


    public List<Patient> getAllPatients() {
        return new ArrayList<>(patients.values());
    }

    public Patient getPatientByID( int id) {
        return patients.get(id);
    }

    public List<Patient> getPatientByDateOfBirthRange(String startDate, String endDate) {
        List<Patient> patientBirth = new ArrayList<>();

        LocalDate startTime = LocalDate.parse(startDate);
        LocalDate endTime = LocalDate.parse(endDate);

        for (Patient patient : patients.values()) {
            if ((patient.getDate_of_birth().isEqual(startTime) || patient.getDate_of_birth().isAfter(startTime)) &&
                    (patient.getDate_of_birth().isEqual(endTime) || patient.getDate_of_birth().isBefore(endTime))) {
                patientBirth.add(patient);
            }
        }
        return patientBirth;
    }

    public List<Patient> getPatientByAdmittingDoctorsDepartment(String department) {
        List<Patient> patientDepartment = new ArrayList<>();

        for (Patient patient : patients.values()) {
            Employee doctor = employees.get(patient.getAddmitted_by());
            if (doctor != null && doctor.getDepartment().equalsIgnoreCase(department)) {
                patientDepartment.add(patient);
            }
        }
        return patientDepartment;
    }

    public List<Patient> getPatientsByDoctorStatusOFF() {
        List<Patient> patientsByDoctorStatusOFF = new ArrayList<>();

        for (Patient patient : patients.values()) {
            Employee doctor = employees.get(patient.getAddmitted_by());
            if (doctor != null && doctor.getStatus() == Status.OFF) {
                patientsByDoctorStatusOFF.add(patient);
            }
        }
        return patientsByDoctorStatusOFF;
    }




}