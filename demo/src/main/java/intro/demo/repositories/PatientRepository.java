package intro.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import intro.demo.model.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByPatientId(Long patientId);
    List<Patient> findByDateOfBirthBetween(String startDate, String endDate);
    List<Patient> findByAdmittedBy(Employee admittedBy);
    List<Patient> findByDoctorStatus(String status);
    List<Patient> findByAdmittingDoctorDepartment(String department);
    @Query("SELECT p FROM Patient p WHERE p.admittedBy.status = :status")
    List<Patient> findPatientsByDoctorStatus(@Param("status") String status);
}

