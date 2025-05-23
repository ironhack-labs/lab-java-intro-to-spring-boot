package Lab402.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Pattern(regexp = ".*//s.*", message = "Must contain a space")
    private String name;

    private LocalDate dateOfBirth; // instead of Date as Date has weird time attached

    @ManyToOne
    @JoinColumn(name="admitted_By")
    @JsonBackReference
    private Employee admittedBy;

}