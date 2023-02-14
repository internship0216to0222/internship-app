package com.example.internshipapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_login_history")
public class UserLoginHistory implements Serializable {
    @Id
    private int id;

    private int userId;

    private String userAgent;

    private String sourceIpAddress;

    private LocalDateTime loggedInAt;
}
