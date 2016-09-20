package com.board.model;


import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by mingook on 2016년7월 27일 (수).
 */
public class Member {
    private String id;
    private String password;

    public Member(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public Member(ResultSet rs) throws SQLException {
        this(
                rs.getString("id"),
                rs.getString("password")
        );
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
