package Lab2JavaSpringBoot.repository;

import Lab2JavaSpringBoot.enums.EmployeeStatus;
import Lab2JavaSpringBoot.model.Employee;
import Lab2JavaSpringBoot.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByEmployeeStatus(EmployeeStatus doctorStatus);

    List<Employee> findByDepartment(String department);

}
