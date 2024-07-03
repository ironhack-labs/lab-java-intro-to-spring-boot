package com.ironhack.controller.interfaces;

import com.ironhack.model.Patient;

import java.time.LocalDate;
import java.util.List;

public interface IPatientController {
    public List<Patient> getAllPatients();
    public Patient getPatientById(Integer id);
    public List<Patient> getAllPatientsByDateOfBirthRange(LocalDate start_date, LocalDate end_date);
    public List<Patient> getAllPatientsByAdmittingDoctorDepartment(String department);
    public List<Patient> getAllPatientsByAdmittingDoctorStatusOff();
}
