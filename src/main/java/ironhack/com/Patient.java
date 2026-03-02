package ironhack.com;

import java.util.Date;

public class Patient {
    private int patientId;
    private String name;
    private String dateOfBirth;
    private int admittedBy;
    public Patient(int patientId, String name, String dateOfBirth, int admittedBy){
        this.patientId=patientId;
        this.name=name;
        this.dateOfBirth=dateOfBirth;
        this.admittedBy=admittedBy;
    }

    public String getDateOfBirth() {return dateOfBirth;}
    public String getName() {return name;}
    public int getPatientId() {return patientId;}
    public int getAdmittedBy() {return admittedBy;}

    public void setPatientId(int patientId) {this.patientId = patientId;}
    public void setName(String name) {this.name = name;}
    public void setDateOfBirth(String dateOfBirth) {this.dateOfBirth = dateOfBirth;}
    public void setAdmittedBy(int admittedBy) {this.admittedBy = admittedBy;}

}
