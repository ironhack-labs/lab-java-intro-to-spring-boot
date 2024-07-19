package ironhack.com.lab9.repository;

import ironhack.com.lab9.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface PatientRepository extends JpaRepository <Patient, Long>  {

//    @Query("SELECT p FROM Patient p where p.date BETWEEN :startDate AND :endDate")
        List<Patient> findPatientByDateBetween(String date, String date2);

        @Query("SELECT p FROM Patient p WHERE p.employeeId.department = :department")
        List<Patient> findPatientByDoctorDepartment(@Param("department") String department);

        @Query("SELECT p FROM Patient p WHERE p.employeeId.status = 'off' ")
        List<Patient> findPatientByDoctorStatusOff();
}
