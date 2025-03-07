package com.labs.lab402.service.interfaces;

import com.labs.lab402.model.Patient;

import java.time.LocalDate;
import java.util.List;

public interface IPatientService {
    List<Patient> getAllPatients();
    Patient getPatientById(Integer id);
    List<Patient> getAllPatientsByDateOfBirthRange(LocalDate startDate, LocalDate finishDate);
    List<Patient> getAllPatientsByAdmittingDoctorDepartment(String department);
    List<Patient> getAllPatientsWhoseDoctorsStatusIsOff();
}
