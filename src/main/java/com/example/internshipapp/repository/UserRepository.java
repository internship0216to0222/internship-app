package com.example.internshipapp.repository;

import com.example.internshipapp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
  @Autowired
  private JdbcTemplate template;

  public List<User> findAll() {
    //SQL定義
    String sql = "select * from user";
    //SQL実行
    SqlRowSet rs = template.queryForRowSet(sql);
    //結果反映
    List<User> list = new ArrayList<>();
    while(rs.next()) {
      list.add(new User(rs.getInt("id"),
              rs.getString("email_address"),
              rs.getString("phone_number"),
              rs.getString("bank"),
              rs.getString("branch"),
              rs.getInt("account_type"),
              rs.getString("account_number")));
    }
    return list;
  }
}