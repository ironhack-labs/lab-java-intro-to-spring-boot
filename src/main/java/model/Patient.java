package model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patientId;
    private String name;
    private Date dateOfBirth;
    @ManyToOne
    @JoinColumn(name = "admitted_by", referencedColumnName = "employee_id")
    private int addmitedBy;

    public Patient(String name, Date dateOfBirth, int addmitedBy) {
        setName(name);
        setDateOfBirth(dateOfBirth);
        setAddmitedBy(addmitedBy);
    }
}
