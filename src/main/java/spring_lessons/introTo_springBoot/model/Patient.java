package spring_lessons.introTo_springBoot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    private Integer patientId;
    private  String name;
    private LocalDate dateOfBirth;
    @ManyToOne
    private Employee admittedBy;

}
