package com.hell.board.model;

import com.hell.board.repository.util.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

/**
 * Created by mingook on 2016년7월 27일 (수).
 */
public class Board {
    private int index;
    private String title;
    private String content;
    private String author;
    private String updated;
    private int hits;

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

    public Board(int index, String title, String content, String author, String updated, int hits) {
        this.title = title;
        this.index = index;
        this.content = content;
        this.author = author;
        this.updated = updated;
        this.hits = hits;
    }

    public Board(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    // 이런식으로 하면.. ResultSet 컬럼의 인덱스 순서에 의존적이긴 하지만. 일단 이렇게..
    public Board(ResultSet rs) throws SQLException {
        this(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                dateFormat.format(rs.getDate(5).getTime()),
                rs.getInt(6)
        );
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public static RowMapper<Board> getRowMapper() {
        return rs -> new Board(
                rs.getInt("index"),
                rs.getString("title"),
                rs.getString("content"),
                rs.getString("author"),
                rs.getString("updated"),
                rs.getInt("hits")
        );
    }
}
