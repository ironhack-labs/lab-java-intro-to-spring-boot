package com.hospital.repository;

import com.hospital.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    List<Empleado> findByStatus(String status);
    List<Empleado> findByDepartment(String department);
}