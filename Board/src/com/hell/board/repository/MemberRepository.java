package com.hell.board.repository;

/**
 * Created by mingook on 2016년7월 27일 (수).
 */

import com.hell.board.model.Member;
import com.hell.board.repository.util.QueryExecutor;

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
        List<Member> members = new ArrayList<>();
        new QueryExecutor() {
            @Override
            protected PreparedStatement query(Connection connection) throws SQLException {
                PreparedStatement pstmt = connection.prepareStatement(
                        "SELECT id, password " +
                                "FROM member " +
                                "WHERE id = ?");
                pstmt.setString(1, id);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    members.add(new Member(rs.getString(1), rs.getString(2)));
                }
                return pstmt;
            }
        }.execute();

        return members.size() == 0 ? null : members.get(0);
    }

    public void save(Member member) {
        new QueryExecutor() {
            @Override
            protected PreparedStatement query(Connection connection) throws SQLException {
                PreparedStatement pstmt =
                        connection.prepareStatement("INSERT INTO member (id, password) VALUES(?, ?)");
                pstmt.setString(1, member.getId());
                pstmt.setString(1, member.getPassword());
                return pstmt;
            }
        }.execute();
    }
}
