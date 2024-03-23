package com.hospital.hospitalmanagment.repositories;

import com.hospital.hospitalmanagment.model.Patient;
import com.hospital.hospitalmanagment.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Integer> {
    List<Patient> findByBirthdayBetween(Date start,Date finish);
    @Query("SELECT p FROM Patient p JOIN p.admittedBy e WHERE e.department = :departmentName")
    List<Patient> findByDoctorsDepartment(@Param("departmentName") String departmentName);

    @Query("SELECT p FROM Patient p JOIN p.admittedBy e WHERE e.status = :doctorStatus")
    List<Patient> findByDoctorsStatus(@Param("doctorStatus") Status doctorStatus);


}
