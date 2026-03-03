package az.lab.intro.entity;

import java.util.Date;

public class PatientEntity {
    private String name;
    private Date dateOfBirth;
    private int admittedBy;
    public PatientEntity(String name, Date dateOfBirth, int admittedBy) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.admittedBy = admittedBy;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public int getAdmittedBy() {
        return admittedBy;
    }
    public void setAdmittedBy(int admittedBy) {
        this.admittedBy = admittedBy;
    }


}
