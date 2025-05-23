package Lab402.Repository;

import Lab402.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findAllByDepartment(String department);
    List<Employee> findAllByEmployeeStatus(Enum employeeStatus);
}
