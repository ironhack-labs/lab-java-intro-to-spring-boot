package com.ironhack.springintroironhack.service;

import com.ironhack.springintroironhack.dto.PatientResponse;
import com.ironhack.springintroironhack.entity.PatientEntity;
import com.ironhack.springintroironhack.mapper.PatientMapper;
import com.ironhack.springintroironhack.model.Department;
import com.ironhack.springintroironhack.model.EmployeeStatus;
import com.ironhack.springintroironhack.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PatientService {
    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    public PatientService(PatientRepository patientRepository, PatientMapper patientMapper) {
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
    }

    public List<PatientResponse> getAll() {
        List<PatientEntity> patients = patientRepository.findAll();
        return patients.stream()
                .map(patientMapper::toResponse).toList();
    }

    public PatientResponse getById(Long id) {
        PatientEntity patientEntity = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient with id " + id + " not found"));
        return patientMapper.toResponse(patientEntity);
    }

    public List<PatientResponse> getByDateOfBirthRange(LocalDate from, LocalDate to) {
        if (from == null || to == null || from.isAfter(to)) {
            throw new RuntimeException("Invalid date range");
        }

        List<PatientEntity> patients = patientRepository.findByDateOfBirthRange(from, to);
        return patients.stream()
                .map(patientMapper::toResponse).toList();
    }

    public List<PatientResponse> getByAdmittingDoctorDepartment(Department department) {
        List<PatientEntity> patients = patientRepository.findByAdmittingDoctorDepartment(department);
        return patients.stream()
                .map(patientMapper::toResponse).toList();
    }

    public List<PatientResponse> getByAdmittingDoctorStatus(EmployeeStatus status) {
        List<PatientEntity> patients = patientRepository.findByAdmittingDoctorStatus(status);
        return patients.stream()
                .map(patientMapper::toResponse).toList();
    }
}
