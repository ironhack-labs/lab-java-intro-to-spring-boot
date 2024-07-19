package ironhack.com.lab9.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "patients")

public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;
    private String name;
    private String date;
    @ManyToOne
    @JoinColumn(name = "admitted_by")
    private Employee employeeId;

    public Patient(String name, String date, Employee employeeId) {
        this.name = name;
        this.date = date;
        this.employeeId = employeeId;
    }
}
