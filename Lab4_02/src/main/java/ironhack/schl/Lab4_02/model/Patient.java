package ironhack.schl.Lab4_02.model;

import jakarta.persistence.*;
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
    private Integer patientId;
    private String name;
    private LocalDate dateOfBirth;

   @ManyToOne
    private Doctor doctor;

    public Patient(Integer patientId, String name){
        this.patientId = patientId;
        this.name = name;
    }

    public Integer getId() {
        return patientId;
    }

    public String getPatient() {
        return name;
    }

    public Integer getAdmittedByDoctorId() {
        return doctor.getId();
    }
}
