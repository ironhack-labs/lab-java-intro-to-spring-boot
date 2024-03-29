package com.ironhack.labjavaintrotospringboot.model.user;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
public class User {
    private String name;
}
