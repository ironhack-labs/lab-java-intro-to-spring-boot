package repository;

import model.EmployeeStatus;
import model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {
    // 5. Get all patients: Create a route to get all patients.
    List<Patient> findAll();

    // 6. Get patient by ID: Create a route to get a patient by patient_id.
    Optional<Patient> findByPatientId(int patientId);

    // 7. Get patients by date of birth range: Create a route to get patients date of birth within a specified range.
    @Query(value = "SELECT * FROM patient WHERE date_of_birth BETWEEN :minDate AND :maxDate")
    List<Patient> findAllByDateOfBirthBetween(@Param("minDate") Date minDate, @Param("maxDate") Date maxDate);

    // 8. Get patients by admitting doctor's department: Create a route to get patients by the department that their admitting doctor is in (For example, get all patients admitted by a doctor in cardiology).
    @Query(value = "SELECT patient.* FROM patient INNER JOIN employee ON patient.admitted_by = employee.employee_id " +
            "WHERE employee.department = :department", nativeQuery = true)
    List<Patient> findAllByDoctorDepartment(@Param("department") String department);

    // 9. Get all patients with a doctor whose status is OFF: Create a route to get all patients with a doctor whose status is OFF.
    @Query(value = "SELECT patient.* FROM patient INNER JOIN employee ON patient.admitted_by = employee.employee_id " +
            "WHERE employee.status = :status", nativeQuery = true)
    List<Patient> findAllByDoctorStatus(@Param("status") EmployeeStatus status);

    @Query(value = "SELECT patient.* FROM patient INNER JOIN employee ON patient.admitted_by = employee.employee_id " +
            "WHERE employee.status = OFF", nativeQuery = true)
    List<Patient> findAllByDoctorStatusIsOff();

}
