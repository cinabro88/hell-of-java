package com.hell.board.controller.board;

import com.hell.board.controller.Command;
import com.hell.board.model.Board;
import com.hell.board.service.BoardService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by mingook on 2016년8월 2일 (화).
 */
public class BoardListCommand extends Command {
    private BoardService boardService;

    public BoardListCommand(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
        boardService = new BoardService();
    }

    @Override
    public void execute() throws IOException, ServletException {
        List<Board> boards = boardService.findAllBoards();
        request.setAttribute("boards", boards);
        request.getRequestDispatcher("WEB-INF/view/board/list.jsp").forward(request, response);
    }
}
