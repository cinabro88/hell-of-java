package com.hell.board.repository;

import com.hell.board.model.Board;
import com.hell.board.repository.util.QueryExecutor;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mingook on 2016년7월 28일 (목).
 */
public class BoardRepository {
    private static BoardRepository instance;

    private BoardRepository() {
    }

    public static BoardRepository getInstance() {
        if (instance == null) {
            instance = new BoardRepository();
        }
        return instance;
    }

    public List<Board> findAll() {
        List<Board> boards = new ArrayList<>();
        new QueryExecutor() {
            @Override
            protected PreparedStatement query(Connection connection) throws SQLException {
                PreparedStatement pstmt = connection.prepareStatement(
                        "SELECT index, title, content, author, updated, hits " +
                                "FROM board");

                ResultSet rs = pstmt.executeQuery();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                while (rs.next()) {
                    java.util.Date updated = new java.util.Date(rs.getDate(5) == null ? 0 : rs.getDate(5).getTime());

                    boards.add(
                            new Board(
                                    rs.getInt(1),
                                    rs.getString(2),
                                    rs.getString(3),
                                    rs.getString(4),
                                    dateFormat.format(updated),
                                    rs.getInt(6)
                            )
                    );
                }
                return pstmt;
            }
        }.execute();

        return boards;
    }

    public void insert(Board board) {
        new QueryExecutor() {
            @Override
            protected PreparedStatement query(Connection connection) throws SQLException {
                PreparedStatement pstmt = connection.prepareStatement(
                        "INSERT INTO board (title, content, author, updated, hits)" +
                                "VALUES(?, ?, ?, ?, ?)"
                );

                pstmt.setString(1, board.getTitle());
                pstmt.setString(2, board.getContent());
                pstmt.setString(3, board.getAuthor());
                pstmt.setDate(4, new Date(System.currentTimeMillis()));
                pstmt.setInt(5, board.getHits());

                pstmt.executeUpdate();

                return pstmt;
            }
        }.execute();
    }
}
