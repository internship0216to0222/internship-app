package com.example.internshipapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;
@Entity
@Data
@Table(name = "user_login_history")

public class UserLoginHistory {
    @Id
     private int  id;
     private int user_id;
     private String user_agent;
     private String source_ip_address;
     private  LocalDateTime logged_in_at;
     private LocalDateTime created_at;
     private LocalDateTime updated_at;




}
