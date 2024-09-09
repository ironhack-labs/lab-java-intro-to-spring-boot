package Lab2JavaSpringBoot.repository;

import Lab2JavaSpringBoot.enums.EmployeeStatus;
import Lab2JavaSpringBoot.model.Employee;
import Lab2JavaSpringBoot.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("SELECT p FROM Patient p WHERE (p.dateOfBirth BETWEEN :startDate AND :endDate)")
    List<Patient> findByBirthDateRangeBetween(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    List<Patient> findByAdmittedBy(Employee admittedBy);

    //accedo a los employee y dentro de employee a su departamento a traves de admittedBy
    @Query("SELECT p FROM Patient p WHERE p.admittedBy.department = :department")
    List<Patient> findByDepartment(String department);

    @Query("SELECT p FROM Patient p WHERE p.admittedBy.employeeStatus = :status")
    List<Patient> findByStatusEmployee(EmployeeStatus status);



}
