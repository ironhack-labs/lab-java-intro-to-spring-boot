package com.example.Spring.repository;

import com.example.Spring.EmployeeStatus;
import com.example.Spring.model.Employee;
import com.example.Spring.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient,String> {
    Optional<Patient> findByPatientId(int patientId);

    List<Patient> findByDateOfBirthBetween(Date initDate, Date endDate);

    @Query(value ="SELECT patient.* FROM patient INNER JOIN employee ON patient.employee_id = employee.employee_id WHERE employee.department = :department", nativeQuery = true)
    List<Patient> findByDoctorDepartment(@Param("department") Optional<String> department);
    @Query(value ="SELECT patient.* FROM patient INNER JOIN employee ON patient.employee_id = employee.employee_id WHERE employee.status = :status", nativeQuery = true)
    List<Patient> findByDoctorStatus(@Param("status") Optional<EmployeeStatus> status);
}
