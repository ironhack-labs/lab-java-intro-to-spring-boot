package com.example.lab_java_intro_to_spring_boot.model;

public class Patient {
    private int id;
    private String name;
    private String date_of_birth;
    private int admitted_by;

    public Patient(int id, String name, String date_of_birth, int admitted_by) {
        this.id = id;
        this.name = name;
        this.date_of_birth = date_of_birth;
        this.admitted_by = admitted_by;
    }

    public Patient() { }

    public int getAdmitted_by() {
        return admitted_by;
    }

    public void setAdmitted_by(int admitted_by) {
        this.admitted_by = admitted_by;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }
}