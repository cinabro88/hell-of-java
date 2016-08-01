package com.hell.board.repository;

import com.hell.board.model.Board;
import com.hell.board.repository.util.QueryExecutor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                        "SELECT index, title, content, author " +
                                "FROM board");

                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    boards.add(new Board(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
                }
                return pstmt;
            }
        }.execute();

        return boards;
    }

    public void save(Board board) {
        new QueryExecutor() {
            @Override
            protected PreparedStatement query(Connection connection) throws SQLException {
                PreparedStatement pstmt = connection.prepareStatement(
                        "INSERT INTO board (title, content, author)" +
                                "VALUES(?, ?, ?)"
                );

                pstmt.setString(1, board.getTitle());
                pstmt.setString(2, board.getContent());
                pstmt.setString(3, board.getAuthor());
                pstmt.executeUpdate();

                return pstmt;
            }
        }.execute();
    }
}
