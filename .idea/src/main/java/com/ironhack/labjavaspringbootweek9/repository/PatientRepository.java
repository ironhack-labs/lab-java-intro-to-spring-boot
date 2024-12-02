package com.ironhack.labjavaspringbootweek9.repository;

import com.ironhack.labjavaspringbootweek9.enums.Status;
import com.ironhack.labjavaspringbootweek9.model.Patient;
import com.ironhack.labjavaspringbootweek9.model.Employee;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByDateOfBirthBetween(LocalDate from, LocalDate to);
    @Query("SELECT p FROM Patient p JOIN p.admitted_by e WHERE e.department = :departmentName")
    List<Patient> findByDoctorsDepartment(@Param("departmentName") String departmentName);
    @Query("SELECT p FROM Patient p JOIN p.admitted_by e WHERE e.status = :doctorStatus")
    List<Patient> findByDoctorsStatus(@Param("doctorStatus") Status doctorStatus);


}
