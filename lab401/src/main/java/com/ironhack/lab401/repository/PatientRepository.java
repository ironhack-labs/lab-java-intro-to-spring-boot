package com.ironhack.lab401.repository;

import com.ironhack.lab401.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    List<Patient> findByDateOfBirth(LocalDate dateOfBirth);
    List<Patient> findByEmployeeEmployeeId(Integer employeeId);
    List<Patient> findByEmployeeDepartment(String department);

//    This line produces error!! Don't use the foreign key of this way.
//    List<Patient> findByAdmittedBy(Integer admittedBy);
}