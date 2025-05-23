package Lab402.Repository;

import Lab402.model.Employee;
import Lab402.model.EmployeeStatus;
import Lab402.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    //@Query(value = "SELECT * FROM patients WHERE employee e.admittedBy && e.department", nativeQuery = true)
    //List<Patient> nativeFindAllPatientsWhereAdmittedByAndDepartmentParams(Integer id, String department );

    @Query(value = "SELECT p.* FROM patient p JOIN employee e ON p.admited_by = e.employee_id WHERE e.department = :department", nativeQuery = true )
    List<Patient>findAllPatientsByDoctorDepartment(@Param("department") String department);
    //gap

    @Query(value = "SELECT p.* FROM patient p JOIN employee e ON e.employee_status =:OFF", nativeQuery = true)
    List<Patient>findAllPatientsByDoctorStatusOff(@Param("OFF")EmployeeStatus employeeStatus);

}
