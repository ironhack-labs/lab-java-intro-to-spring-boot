package com.example.demo;

import java.util.Date;

public class Patient {
    private long id;
    private String name;
    private Date date_of_birth;
    private Employee admitted_by;

    public long getId() {
        return id;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public String getName() {
        return name;
    }

    public Employee getAdmitted_by() {
        return admitted_by;
    }

    public Patient(long id, String name, Date date_of_birth, Employee admitted_by) {
        this.id = id;
        this.name = name;
        this.date_of_birth = date_of_birth;
        this.admitted_by = admitted_by;
    }
}
