package com.board.service;

import com.board.model.Board;
import com.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by mingook on 2016년7월 30일 (토).
 */
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public List<Board> findAllBoards() {
        return boardRepository.findAll();
    }

    public void writeBoard(String title, String content, String author) {
        Board board = new Board(title, content, author);
        boardRepository.insert(board);
    }

    public Board findBoardByIndex(int index) {
        return boardRepository.findByIndex(index);
    }
}
