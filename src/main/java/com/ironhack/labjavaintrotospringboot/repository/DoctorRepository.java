package com.ironhack.labjavaintrotospringboot.repository;

import com.ironhack.labjavaintrotospringboot.model.user.Department;
import com.ironhack.labjavaintrotospringboot.model.user.Doctor;
import com.ironhack.labjavaintrotospringboot.model.user.DoctorStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    Optional<Doctor> findById(int doctorId);
    List<Doctor> findByStatus(DoctorStatus status);
    List<Doctor> findByDepartment(Department department);
}
