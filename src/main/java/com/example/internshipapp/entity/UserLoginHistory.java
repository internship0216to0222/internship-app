package com.example.internshipapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginHistory implements Serializable {

    private int id;

    private int userId;

    private String userAgent;

    private String sourceIpAddress;

    private LocalDateTime loggedInAt;
}

