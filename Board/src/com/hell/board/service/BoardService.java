package com.hell.board.service;

import com.hell.board.model.Board;
import com.hell.board.repository.BoardRepository;

import java.util.List;

/**
 * Created by mingook on 2016년7월 30일 (토).
 */
public class BoardService {
    private BoardRepository repository = BoardRepository.getInstance();

    public List<Board> findAllBoards() {
        return repository.findAll();
    }

    public void writeBoard(String title, String content, String author) {
        Board board = new Board(title, content, author);
        repository.insert(board);
    }

    public Board findBoardByIndex(int index) {
        return repository.findByIndex(index);
    }
}
