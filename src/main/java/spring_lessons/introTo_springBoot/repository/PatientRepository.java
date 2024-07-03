package spring_lessons.introTo_springBoot.repository;

import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring_lessons.introTo_springBoot.model.Patient;
import spring_lessons.introTo_springBoot.model.Status;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    //JPL
    List<Patient> findByDateOfBirthBetween(LocalDate startDate, LocalDate endDate);
    //native sql
    @Query("SELECT p FROM Patient p JOIN p.admittedBy e WHERE e.department = :department")
    List<Patient> findAllWhereDepartmentIs(String department);

    @Query("SELECT p FROM Patient p JOIN p.admittedBy e WHERE e.status = 'OFF'")
    List<Patient> findAllWhereDoctorStatusIsOff();

}
