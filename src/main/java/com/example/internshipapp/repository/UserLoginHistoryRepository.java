package com.example.internshipapp.repository;

import com.example.internshipapp.entity.UserLoginHistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserLoginHistoryRepository extends JpaRepository<UserLoginHistory, Integer> {
    @Query
    List<UserLoginHistory> findAllBy();

}
