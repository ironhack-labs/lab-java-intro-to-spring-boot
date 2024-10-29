package org.example.springbootlab.repository;

import org.example.springbootlab.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    List<Doctor> findByStatus(String status);
    List<Doctor> findByDepartment(String department);

}
