package com.hell.board.repository;

import com.hell.board.model.Board;

/**
 * Created by mingook on 2016년7월 28일 (목).
 */
public class BoardRepository extends BaseRepository<Board> {
    private static BoardRepository instance;

    private BoardRepository() {
    }

    public static BoardRepository getInstance() {
        if (instance == null) {
            instance = new BoardRepository();
        }
        return instance;
    }
}
