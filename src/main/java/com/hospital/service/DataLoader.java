package com.hospital.service;

import com.hospital.model.Empleado;
import com.hospital.model.Paciente;
import com.hospital.repository.EmpleadoRepository;
import com.hospital.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public void run(String... args) throws Exception {
        loadEmployees();
        loadPatients();
    }

    private void loadEmployees() {
        // Aquí puedes agregar la lógica para cargar empleados de ejemplo
    }

    private void loadPatients() {
        // Aquí puedes agregar la lógica para cargar pacientes de ejemplo
    }
}
