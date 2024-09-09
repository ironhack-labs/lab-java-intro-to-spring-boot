package Lab2JavaSpringBoot.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data // ya me da getters y setters, constructor vacio y constructor lleno
@Entity
public class Patient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;

    private String name;

    private LocalDate dateOfBirth;
    @ManyToOne
    @JoinColumn(name = "admittedBy")
    private Employee admittedBy;
}
