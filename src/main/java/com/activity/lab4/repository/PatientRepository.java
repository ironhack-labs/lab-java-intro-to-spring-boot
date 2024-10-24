package com.activity.lab4.repository;

import ch.qos.logback.core.status.Status;
import com.activity.lab4.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
List<Patient> findDateOfBirthBetween(Date startDate, Date endDate);
List<Patient> findByAdmittedBy_Id(Long id);
List<Patient> findByAdmittedBy_Department(String department);
List<Patient> findByAdmittedBy_Status(Status status);

}
