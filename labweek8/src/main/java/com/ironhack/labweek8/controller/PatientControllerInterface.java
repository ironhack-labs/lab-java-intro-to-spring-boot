package com.ironhack.labweek8.controller;

import com.ironhack.labweek8.model.Patient;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface PatientControllerInterface {
    List<Patient> getPatients();

    Patient getPatientById(int id);

    List<Patient> getPatientsWithBirthdateRange(LocalDate from, LocalDate to);

    List<Patient> getPatientsByDoctorDepartment(String department);

    List<Patient> getPatientsWithDoctorStatusOff();
}