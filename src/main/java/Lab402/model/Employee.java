package Lab402.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id  //usa info limitada y especifica, no usar generated value
    @NotNull
    private Integer id;
    private String department;

    @Pattern(regexp = ".*\\s.*", message = "Must contain a space")
    private String name;

    @Enumerated(EnumType.STRING)
    private EmployeeStatus employeeStatus;


    //
    @OneToMany(mappedBy = "admittedBy")
    @JsonManagedReference
    private List<Patient> admittedPatients = new ArrayList<>();



}
