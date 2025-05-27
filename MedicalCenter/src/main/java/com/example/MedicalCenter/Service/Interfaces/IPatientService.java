package com.example.MedicalCenter.Service.Interfaces;

import com.example.MedicalCenter.Model.EmployeeStatus;
import com.example.MedicalCenter.Model.Patient;

import java.time.LocalDate;
import java.util.List;


public interface IPatientService {

    List<Patient> getAllPatients();

    Patient getPatientById(Long id);


    List<Patient> getPatientsByDateOfBirth(LocalDate startDate, LocalDate endDate);

    List<Patient> getPatientsByAdmittingDoctorId(Long doctorId);

    List<Patient> getPatientsByDoctorDepartment(String department);

    List<Patient> getPatientsByDoctorByStatusOff(EmployeeStatus status);
}