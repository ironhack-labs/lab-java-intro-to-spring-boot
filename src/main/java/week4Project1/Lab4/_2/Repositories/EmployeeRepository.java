package week4Project1.Lab4._2.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import week4Project1.Lab4._2.Models.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByStatus(String status);
    List<Employee> findByDepartment(String department);
}
