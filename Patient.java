import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    private Long patientId;
    private String name;
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    private Long admittedBy; // This will be a simple mapping by employee_id

    // Constructors, getters, and setters
}