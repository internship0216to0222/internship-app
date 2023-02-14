package com.example.internshipapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    private int id;
    private String emailAddress;

    private String phoneNumber;

    private String bank;

    private String branch;

    private int accountType;

    private String accountNumber;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private List<UserLoginHistory> userLoginHistories = new ArrayList<>();
}
