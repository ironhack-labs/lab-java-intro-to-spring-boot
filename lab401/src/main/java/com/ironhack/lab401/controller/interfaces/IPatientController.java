package com.ironhack.lab401.controller.interfaces;

import com.ironhack.lab401.model.Employee;
import com.ironhack.lab401.model.Patient;

import java.time.LocalDate;
import java.util.List;

public interface IPatientController {
    List<Patient> getAllPatient();
    Patient getPatientById(Integer id);
    List<Patient> getPatientByDateOfBirthRange(LocalDate dateOfBirth);
    List<Patient> getPatientByDepartmentDoctor(String  department);
    List<Patient> getPatientWithDoctorStatusOFF(Integer id);

//    void savePatient(Patient patient);
}
