package spring_lessons.introTo_springBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_lessons.introTo_springBoot.model.Employee;
import spring_lessons.introTo_springBoot.model.Status;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //JPL
    List<Employee> findAllByStatus(Status status);
    List<Employee> findAllByDepartment(String department);

}
