package com.example.paginationdemo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
@Data
public class User {
    @Id
    private Integer id;
    @Version
    private int version;
    private String username;
    private String fullName;
}
