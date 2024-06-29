import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    private Long employeeId;
    private String department;
    private String name;
    private String status;

    // Constructors, getters, and setters
}
