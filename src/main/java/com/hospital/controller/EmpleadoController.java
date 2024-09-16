package com.hospital.controller;

import com.hospital.model.Empleado;
import com.hospital.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping
    public List<Empleado> getAllEmployees() {
        return empleadoService.getAllEmpleados();
    }

    @GetMapping("/{id}")
    public Empleado getEmpleadoById(@PathVariable Long id) {
        return empleadoService.getEmpleadoById(id);
    }

    @GetMapping("/status/{status}")
    public List<Empleado> getEmpleadosByStatus(@PathVariable String status) {
        return empleadoService.getEmpleadosByStatus(status);
    }

    @GetMapping("/department/{department}")
    public List<Empleado> getEmpleadosByDepartment(@PathVariable String department) {
        return empleadoService.getEmpleadosByDepartment(department);
    }



}
