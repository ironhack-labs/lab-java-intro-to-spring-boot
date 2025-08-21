package com.labs.lab402.controller.interfaces;

import com.labs.lab402.model.Patient;

import java.time.LocalDate;
import java.util.List;

public interface IPatientController {
    List<Patient> getAllPatients();
    Patient getPatientById(Long patientId);
    List<Patient> getPatientsByDateOfBirthRange(LocalDate start, LocalDate end);
    List<Patient> getPatientsByDoctorDepartment(String department);
    List<Patient> getPatientsByDoctorStatusOFF();
}
