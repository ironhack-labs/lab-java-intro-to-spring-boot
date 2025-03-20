package com.ironhack.lab401.service.interfaces;

import com.ironhack.lab401.model.Employee;
import com.ironhack.lab401.model.EmployeeStatus;
import com.ironhack.lab401.model.Patient;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IPatientService {
    List<Patient> getAllPatient();
    Patient getPatientById(Integer id);
    List<Patient> getPatientByDateOfBirthRange(LocalDate dateOfBirth);
    List<Patient> getPatientByDepartmentDoctor(String  department);
    List<Patient> getPatientWithDoctorStatusOFF(Integer id);

//    void savePatient(Patient patient);

}
