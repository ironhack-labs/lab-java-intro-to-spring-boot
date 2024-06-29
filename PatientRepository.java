import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Date;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("SELECT p FROM Patient p WHERE p.dateOfBirth BETWEEN :startDate AND :endDate")
    List<Patient> findAllByDateOfBirthBetween(Date startDate, Date endDate);

    @Query("SELECT p FROM Patient p JOIN Employee e ON p.admittedBy = e.employeeId WHERE e.department = :department")
    List<Patient> findAllByAdmittingDoctorDepartment(String department);

    @Query("SELECT p FROM Patient p JOIN Employee e ON p.admittedBy = e.employeeId WHERE e.status = 'OFF'")
    List<Patient> findAllWithDoctorStatusOff();
}
