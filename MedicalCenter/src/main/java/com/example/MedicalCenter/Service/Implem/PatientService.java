package com.example.MedicalCenter.Service.Implem;

import com.example.MedicalCenter.Model.EmployeeStatus;
import com.example.MedicalCenter.Model.Patient;
import com.example.MedicalCenter.Repository.PatientRepository;
import com.example.MedicalCenter.Service.Interfaces.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService implements IPatientService {

    @Autowired
    PatientRepository patientRepository;

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(Long id) {
        Optional<Patient> patientOptional = patientRepository.findById(id);
        if (patientOptional.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "patient" + id + "not found");
        return patientOptional.get();
    }

    @Override
    public List<Patient> getPatientsByDateOfBirth(LocalDate startDate, LocalDate endDate) {
        return patientRepository.findByDateOfBirthBetween(startDate, endDate);
    }

    @Override
    public List<Patient> getPatientsByAdmittingDoctorId(Long doctorId) {
        return patientRepository.findByAdmittedById(doctorId);
    }

    @Override
    public List<Patient> getPatientsByDoctorDepartment(String department) {
        return patientRepository.findByAdmittedByDepartment(department);
    }

    @Override
    public List<Patient> getPatientsByDoctorByStatusOff(EmployeeStatus status) {
        return patientRepository.findByAdmittedByStatus(EmployeeStatus.OFF);
    }


}

















