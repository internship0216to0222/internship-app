package com.example.internshipapp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private int id;
    private String emailAddress;

    private String phoneNumber;

    private String bank;

    private String branch;

    private int accountType;

    private String accountNumber;
}
