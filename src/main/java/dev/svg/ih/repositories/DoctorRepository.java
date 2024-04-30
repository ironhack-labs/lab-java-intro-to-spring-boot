package dev.svg.ih.repositories;

import dev.svg.ih.model.Doctor;
import dev.svg.ih.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    List<Doctor> findByStatus(String status);
    List<Doctor> findByDepartment(String department);
    List<Doctor> findByStatusAndDepartment(String status, String department);
    @Query("SELECT p FROM Patient p JOIN p.doctor d WHERE d.status = 'OFF'")
    List<Patient> findPatientsWithDoctorHavingStatusOff();
}
