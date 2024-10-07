package com.nusiss.commonservice.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class User {

    private Integer userId;

    private String username;

    private String email;

    private String password;

    private Role role;

    private LocalDateTime createDatetime;

    private LocalDateTime updateDatetime;

    private String createUser;

    private String updateUser;

    protected void onCreate() {
        this.createDatetime = LocalDateTime.now();
        this.updateDatetime = LocalDateTime.now();
    }

    protected void onUpdate() {
        this.updateDatetime = LocalDateTime.now();
    }

    // Getters and Setters

    public enum Role {
        CUSTOMER, SELLER, ADMIN
    }

    // Add constructors, getters, and setters...
}