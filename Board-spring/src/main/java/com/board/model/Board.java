package com.board.model;

import java.sql.Date;
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

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

    public Board(int index, String title, String content, String author, Date updated, int hits) {
        this.title = title;
        this.index = index;
        this.content = content;
        this.author = author;
        this.updated = dateFormat.format(updated);
        this.hits = hits;
    }

    public Board(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Board(ResultSet rs) throws SQLException {
        this(
                rs.getInt("index"),
                rs.getString("title"),
                rs.getString("content"),
                rs.getString("author"),
                rs.getDate("updated"),
                rs.getInt("hits")
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
}
