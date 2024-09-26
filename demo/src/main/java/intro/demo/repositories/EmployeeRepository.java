package intro.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import intro.demo.model.*;
import java.util.List;
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByEmployeeId(Long employeeId);
    List<Employee> findByStatus(String status);
    List<Employee> findByDepartment(String department);
}
