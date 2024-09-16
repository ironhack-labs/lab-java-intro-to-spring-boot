    package com.hospital.service;

    import com.hospital.model.Empleado;
    import com.hospital.repository.EmpleadoRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;
    import java.util.List;

    @Service
    public class EmpleadoService {
        @Autowired
        private EmpleadoRepository empleadoRepository;

        // Implementa métodos para todas las operaciones requeridas
        public List<Empleado> getAllEmpleados() {
            return empleadoRepository.findAll();
        }

        public Empleado getEmpleadoById(Long empleadoId) {
            return empleadoRepository.findById(empleadoId).orElse(null);
        }

        public List<Empleado> getEmpleadosByStatus(String status) {
            return empleadoRepository.findByStatus(status);
        }

        public List<Empleado> getEmpleadosByDepartment(String department) {
            return empleadoRepository.findByDepartment(department);
        }



    }
