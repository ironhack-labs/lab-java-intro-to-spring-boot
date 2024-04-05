package org.example.repository;

import org.example.model.Patient;
import org.example.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface IPatientRepository extends JpaRepository<Patient, Integer> {

    List<Patient> findAll();
    Optional<Patient> findById(Integer id);
    List<Patient> findByDateOfBirthBetween(Date startDate, Date endDate);

    @Query(value = "SELECT p.* FROM patient p INNER JOIN employee e ON p.admitted_by = e.employee_id " +
            "WHERE e.department = :department", nativeQuery = true)
    Optional<List<Patient>> findPatientsByEmployeeDepartment( @Param("department")String department);

    @Query(value = "SELECT p.* FROM patient p INNER JOIN employee e ON p.admitted_by = e.employee_id " +
            "WHERE e.status = 'OFF'", nativeQuery = true)
    Optional<List<Patient>> findPatientsByEmployeeStatusOff();
}
