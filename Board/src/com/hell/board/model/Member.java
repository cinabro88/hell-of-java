package com.hell.board.model;

import com.hell.board.repository.util.RowMapper;

/**
 * Created by mingook on 2016년7월 27일 (수).
 */
public class Member {
    private String id;
    private String password;

    public Member() {
    }

    public Member(String id, String password) {
        this.id = id;
        this.password = password;
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

    public static RowMapper<Member> getRowMapper() {
        return rs -> new Member(rs.getString("id"), rs.getString(("password")));
    }
}
