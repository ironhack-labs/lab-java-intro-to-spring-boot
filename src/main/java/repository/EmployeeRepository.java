package repository;

import model.Employee;
import model.EmployeeStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    // List<Flight> findAllByFlightNumber(String flightNumber);

    // 1. Get all doctors: Create a route to get all doctors.
    List<Employee> findAll();

    // 2. Get doctor by ID: Create a route to get a doctor by employee_id.
    Optional<Employee> findByEmployeeId(int employeeId);

    // 3. Get doctors by status: Create a route to get doctors by status.
    List<Employee> findAllByStatus(EmployeeStatus status);

    // 4. Get doctors by department: Create a route to get doctors by department.
    List<Employee> findAllByDepartment(String department);

}