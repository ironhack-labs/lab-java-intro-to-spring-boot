package com.hospital.controller;

import com.hospital.model.Paciente;
import com.hospital.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public List<Paciente> getAllPacientes() {
        return pacienteService.getAllPatients();
    }

    @GetMapping("/{id}")
    public Paciente getPacienteById(@PathVariable Long id) {
        return pacienteService.getPacienteById(id);
    }

    @GetMapping("/admitted/department/{department}")
    public List<Paciente> getPacientesByAdmittingDoctorDepartment(@PathVariable String department) {
        return pacienteService.getPacientesByAdmittingDoctorDepartment(department);
    }

    @GetMapping("/admitted/status/off")
    public List<Paciente> getPacientesByDoctorStatusOff() {
        return pacienteService.getPacientesByDoctorStatusOff();
    }





}
