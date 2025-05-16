package com.ironhack.Lab402IntroToSpringBoot202302.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hospId;

    private String hospName;
    private String region;
    private String city;

    public Hospital(String hospName, String region, String city) {
        this.hospName = hospName;
        this.region = region;
        this.city = city;
    }
}
