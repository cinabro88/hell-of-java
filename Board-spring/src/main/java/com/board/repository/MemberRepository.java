package com.board.repository;

/**
 * Created by mingook on 2016년7월 27일 (수).
 */

import com.board.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class MemberRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public MemberRepository(DataSource dataSources) {
        this.jdbcTemplate = new JdbcTemplate(dataSources);
    }

    public Member findById(String id) {
        return jdbcTemplate.queryForObject(
                "SELECT id, password " +
                        "FROM member " +
                        "WHERE id = ?",
                (rs, rowNum) -> new Member(rs),
                id
        );
    }

    public int insert(Member member) {
        return jdbcTemplate.update("INSERT INTO member (id, password) VALUES(?, ?)",
                member.getId(), member.getPassword());
    }
}
