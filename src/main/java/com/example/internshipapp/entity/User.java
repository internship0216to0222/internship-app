package com.example.internshipapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;
@Entity
@Data
@Table(name = "user")
public class User {
    @Id
    private int id;

    private String email_address;

    private String phone_number;

    private String bank;

    private String branch;

    private String account_type;

    private String account_number;

    private LocalDateTime created_at;


    private LocalDateTime updated_at;
    private String name;


}
