package repository;

import model.Employee;
import model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {



    List<Employee> findByStatus(Status status);

    List<Employee> findByDepartment(String department);
}

