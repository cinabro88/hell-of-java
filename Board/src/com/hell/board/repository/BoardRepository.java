package com.hell.board.repository;

import com.hell.board.model.Board;
import com.hell.board.repository.util.JdbcExecutor;

import java.sql.Date;
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
        return JdbcExecutor.query(connection -> connection.prepareStatement(
                "SELECT index, title, content, author, updated, hits " +
                        "FROM board " +
                        "ORDER BY index DESC "),
                Board.getRowMapper()
        );
    }

    public int insert(Board board) {
        return JdbcExecutor.update(
                connection -> connection.prepareStatement(
                        "INSERT INTO board (title, content, author, updated, hits)" +
                                "VALUES(?, ?, ?, ?, ?)"
                ),
                board.getTitle(),
                board.getContent(),
                board.getAuthor(),
                new Date(System.currentTimeMillis()),
                0
        );
    }

    public Board findByIndex(int index) {
        return JdbcExecutor.queryForObject(
                connection -> connection.prepareStatement(
                        "SELECT index, title, content, author, updated, hits " +
                                "FROM board " +
                                "WHERE index=?"
                ),
                Board.getRowMapper(),
                index
        );
    }
}
