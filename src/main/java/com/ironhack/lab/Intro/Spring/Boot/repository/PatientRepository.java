package com.ironhack.lab.Intro.Spring.Boot.repository;

import com.ironhack.lab.Intro.Spring.Boot.Enum.Department;
import com.ironhack.lab.Intro.Spring.Boot.Enum.Status;
import com.ironhack.lab.Intro.Spring.Boot.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    @Query("SELECT p FROM Patient p WHERE p.dateOfBirth BETWEEN :startDate AND :endDate")
    List<Patient> findByDateOfBirthBetween(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query("SELECT p FROM Patient p JOIN p.admittedBy e WHERE e.department = ?1")
    List<Patient> findAllByEmployeeDepartment(Department department);



    @Query("SELECT p FROM Patient p JOIN p.admittedBy e WHERE e.status = ?1")
    List<Patient> findAllByEmployeeStatus(Status status);
    @Query("SELECT p FROM Patient p JOIN p.admittedBy e WHERE e.status = OFF")
    List<Patient> findAllByEmployeeStatusOff();

}
