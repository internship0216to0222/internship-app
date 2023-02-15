package com.example.internshipapp.repository;

import com.example.internshipapp.entity.User;
import com.example.internshipapp.entity.UserLoginHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class UserRepository {
  @Autowired
  private NamedParameterJdbcTemplate template;

  private static final ResultSetExtractor<List<User>> USER_USER_LOGIN_HISTORY_MEMBER_RESULTSET = (rs) -> {
    List<User> users = new ArrayList<>();

    List<UserLoginHistory> userLoginHistories = null;

    int beforeIdNum = 0;

    while(rs.next()) {
      int nowIdNum = rs.getInt("u_id");

      if (nowIdNum != beforeIdNum) {
        User user = new User();
        user.setId(nowIdNum);
        user.setEmailAddress(rs.getString("u_email_address"));
        user.setPhoneNumber(rs.getString("u_phone_number"));
        user.setBank(rs.getString("u_bank"));
        user.setBranch(rs.getString("u_branch"));
        user.setAccountType(rs.getInt("u_account_type"));
        user.setAccountNumber(rs.getString("u_account_number"));

        userLoginHistories = new ArrayList<>();
        user.setUserLoginHistories(userLoginHistories);
        users.add(user);
      }

      if (rs.getInt("ulh_id") != 0) {
        UserLoginHistory userLoginHistory = new UserLoginHistory();
        userLoginHistory.setId(rs.getInt("ulh_id"));
        userLoginHistory.setUserId(rs.getInt("ulh_user_id"));
        userLoginHistory.setUserAgent(rs.getString("ulh_user_agent"));
        userLoginHistory.setSourceIpAddress(rs.getString("ulh_source_ip_address"));
        userLoginHistory.setLoggedInAt(rs.getTimestamp("ulh_logged_in_at").toLocalDateTime());
        Objects.requireNonNull(userLoginHistories).add(userLoginHistory);
      }

      beforeIdNum = nowIdNum;
    }
    return users;
  };

  public List<User> findAll() {
    String sql = "SELECT u.id as u_id, u.email_address as u_email_address, u.phone_number as u_phone_number, " +
            "u.bank as u_bank, u.branch as u_branch, u.account_type as u_account_type, u.account_number as u_account_number, " +
            "ulh.id as ulh_id, ulh.user_id as ulh_user_id, ulh.user_agent as ulh_user_agent, ulh.source_ip_address as ulh_source_ip_address," +
            "ulh.logged_in_at as ulh_logged_in_at FROM user u LEFT JOIN user_login_history ulh ON u.id = ulh.user_id " +
            "ORDER BY u.id ASC, ulh.id DESC;";
    return template.query(sql, USER_USER_LOGIN_HISTORY_MEMBER_RESULTSET);
  }
}