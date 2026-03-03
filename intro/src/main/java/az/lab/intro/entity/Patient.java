package az.lab.intro.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;



public class Patient {

public static Map<Integer, PatientEntity> patients = new HashMap<>();


static {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            patients.put(1, new PatientEntity(
                "Jaime Jordan",
                sdf.parse("1984-03-02"),
                564134
            ));
            patients.put(2, new PatientEntity(
                "Marian Garcia",
                sdf.parse("1972-01-12"),
                564134
            ));
            patients.put(3, new PatientEntity(
                "Julia Dusterdieck",
                sdf.parse("1954-06-11"),
                356712
            ));
            patients.put(4, new PatientEntity(
                "Steve McDuck",
                sdf.parse("1931-11-10"),
                761527
            ));
            patients.put(5, new PatientEntity(
                "Marian Garcia",
                sdf.parse("1999-02-15"),
                172456
            ));

        } catch(Exception e) {
            e.printStackTrace();
        }
    }


public Patient() {
}


public Map<Integer, PatientEntity> getPatients() {
    return patients;
}

    


}
