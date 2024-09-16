package com.hospital.service;

import com.hospital.model.Paciente;
import com.hospital.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    // Implementa métodos para todas las operaciones requeridas
    public List<Paciente> getAllPatients() {
        return pacienteRepository.findAll();
    }

    public Paciente getPacienteById(Long patientId) {
        return pacienteRepository.findById(patientId).orElse(null);
    }

    public List<Paciente> getPacientesByAdmittingDoctorDepartment(String department) {
        return pacienteRepository.findByAdmittedByDepartment(department);
    }

    public List<Paciente> getPacientesByDoctorStatusOff() {
        return pacienteRepository.findByAdmittedByStatus("OFF");
    }




}
