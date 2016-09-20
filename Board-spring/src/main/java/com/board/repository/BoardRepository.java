package com.board.repository;

import com.board.model.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Date;
import java.util.List;

/**
 * Created by mingook on 2016년7월 28일 (목).
 */
public class BoardRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BoardRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Board> findAll() {
        return jdbcTemplate.query(
                "SELECT index, title, content, author, updated, hits " +
                        "FROM board " +
                        "ORDER BY index DESC ",
                (rs, rowNum) -> new Board(rs)
        );
    }

    public int insert(Board board) {
        return jdbcTemplate.update(
                "INSERT INTO board (title, content, author, updated, hits)" +
                        "VALUES(?, ?, ?, ?, ?)",
                board.getTitle(),
                board.getContent(),
                board.getAuthor(),
                new Date(System.currentTimeMillis()),
                0
        );
    }

    public Board findByIndex(int index) {
        return jdbcTemplate.queryForObject(
                "SELECT index, title, content, author, updated, hits " +
                        "FROM board " +
                        "WHERE index=?",
                (rs, rowNum) -> new Board(rs),
                index
        );
    }
}
