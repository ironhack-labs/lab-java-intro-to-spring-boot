package ironhack.com.lab9.repository;

import ironhack.com.lab9.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findAllByStatusIgnoreCase(String status);

    List<Employee> findAllByDepartmentIgnoreCase(String department);


}