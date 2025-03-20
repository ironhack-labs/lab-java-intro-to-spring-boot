package com.ironhack.lab401.service.impl;

import com.ironhack.lab401.model.Employee;
import com.ironhack.lab401.model.EmployeeStatus;
import com.ironhack.lab401.model.Patient;
import com.ironhack.lab401.repository.EmployeeRepository;
import com.ironhack.lab401.repository.PatientRepository;
import com.ironhack.lab401.service.interfaces.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService implements IPatientService{

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Patient> getAllPatient() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(Integer patient_id) {
        Optional <Patient> patient = patientRepository.findById(patient_id);
        if(patient.isEmpty()) return null;
        return patient.get();
    }

    @Override
    public List<Patient> getPatientByDateOfBirthRange(LocalDate dateOfBirth) {
        return patientRepository.findByDateOfBirth(dateOfBirth);
    }

    @Override
    public List<Patient> getPatientByDepartmentDoctor(String department) {
        return patientRepository.findByEmployeeDepartment(department);

//        List<Employee> doctors = employeeRepository.findByDepartment(department);
//        List<Patient> patients = new ArrayList<>();
//
//        for (int j=0 ; j<doctors.size(); j++){
//           List<Patient> patientByDoctor = new ArrayList<>();
//           patientByDoctor = patientRepository.findByEmployeeEmployeeId(doctors.get(j).getEmployeeId());
//
//           for(int i = 0; i<patientByDoctor.size() ; i++){
//               patients.add(patientByDoctor.get(i));
//           }
//
//        }
//
//        return patients;
    }

    @Override
    public List<Patient> getPatientWithDoctorStatusOFF(Integer id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isEmpty()) return null;
        if(!employee.get().getEmployeeStatus().equals(EmployeeStatus.OFF)) return null;

        return patientRepository.findByEmployeeEmployeeId(employee.get().getEmployeeId());
    }

//    @Override
//    public void savePatient(Patient patient) {
//            patientRepository.save(patient);
//    }


}
