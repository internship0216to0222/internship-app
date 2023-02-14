package com.example.internshipapp.repository;

import com.example.internshipapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

  @Query("SELECT DISTINCT u FROM User u LEFT JOIN UserLoginHistory ulh on u.id = ulh.userId")
  List<User> findAll();
}