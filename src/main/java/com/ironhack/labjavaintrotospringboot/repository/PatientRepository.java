package com.ironhack.labjavaintrotospringboot.repository;

import com.ironhack.labjavaintrotospringboot.enums.StatusEnum;
import com.ironhack.labjavaintrotospringboot.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    public List<Patient> findByDateOfBirthBetween(LocalDate firstDate, LocalDate lastDate);
    public List<Patient> findByAdmittedByDepartmentIgnoreCase(String department);
    public List<Patient> findByAdmittedByStatus(StatusEnum status);
}
