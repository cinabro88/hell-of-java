package com.hell.board.controller.board;

import com.hell.board.controller.Command;
import com.hell.board.model.Board;
import com.hell.board.service.BoardService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mingook on 2016년8월 3일 (수).
 */
public class BoardDetailCommand extends Command {
    private BoardService boardService;

    public BoardDetailCommand(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
        boardService = new BoardService();
    }

    @Override
    public void execute() throws IOException, ServletException {
        int index = Integer.parseInt(request.getParameter("index"));
        Board board = boardService.findBoardByIndex(index);
        board.setContent(board.getContent().replaceAll("\r\n", "<br>"));
        request.setAttribute("board", board);
        request.getRequestDispatcher("WEB-INF/view/board/detail.jsp").forward(request, response);
    }
}
