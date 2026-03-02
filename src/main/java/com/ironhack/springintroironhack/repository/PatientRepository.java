package com.ironhack.springintroironhack.repository;

import com.ironhack.springintroironhack.entity.PatientEntity;
import com.ironhack.springintroironhack.model.Department;
import com.ironhack.springintroironhack.model.EmployeeStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends JpaRepository<PatientEntity, Long> {

    @Query("""
        SELECT p
        FROM PatientEntity p
        WHERE p.dateOfBirth BETWEEN :from AND :to
    """)
    List<PatientEntity> findByDateOfBirthRange(
            @Param("from") LocalDate from,
            @Param("to") LocalDate to
    );

    @Query("""
        SELECT p
        FROM PatientEntity p
        INNER JOIN EmployeeEntity e
            ON p.admitted_by = e.id
        WHERE e.department = :department
    """)
    List<PatientEntity> findByAdmittingDoctorDepartment(
            @Param("department") Department department
    );

    @Query("""
        SELECT p
        FROM PatientEntity p
        INNER JOIN EmployeeEntity e
            ON p.admitted_by = e.id
        WHERE e.status = :status
    """)
    List<PatientEntity> findByAdmittingDoctorStatus(
            @Param("status") EmployeeStatus status
    );
}
