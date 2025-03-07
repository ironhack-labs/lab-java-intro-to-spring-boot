package com.labs.lab402.repository;

import com.labs.lab402.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    List<Patient> getAllByDateOfBirthBetween(LocalDate startDate, LocalDate finishDate);

    @Query(value = "SELECT p.* FROM Patient AS p JOIN Employee AS e ON p.admitted_by=e.employee_id WHERE e.department = ?1", nativeQuery = true)
    List<Patient> getAllByDoctorDepartment(String department);

    @Query(value = "SELECT p.* FROM Patient AS p JOIN Employee AS e ON p.admitted_by=e.employee_id WHERE e.status = 'OFF'", nativeQuery = true)
    List<Patient> getAllByDoctorsStatusIsOff();

}
