package com.hell.board.repository;

/**
 * Created by mingook on 2016년7월 27일 (수).
 */

import com.hell.board.model.Member;
import com.hell.board.repository.util.JdbcExecutor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberRepository {

    private static MemberRepository instance;

    private MemberRepository() {
    }

    public static MemberRepository getInstance() {
        if (instance == null) {
            instance = new MemberRepository();
        }
        return instance;
    }

    /*
     * 익명클래스를 이용해서 보일러플레이트 코드를 제거하니까, select할때에 불편한게 몇가지 있다..
     * 더 좋은 방법은 없을까?
     */
    public Member findById(String id) {
        return JdbcExecutor.queryForObject(
                connection -> connection.prepareStatement(
                        "SELECT id, password " +
                                "FROM member " +
                                "WHERE id = ?"
                ),
                Member.getRowMapper(),
                id
        );
    }

    public int insert(Member member) {
        return JdbcExecutor.update(
                connection -> connection.prepareStatement("INSERT INTO member (id, password) VALUES(?, ?)"),
                member.getId(), member.getPassword()
        );
    }
}
