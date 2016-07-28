package com.hell.board.controller;

import com.hell.board.model.Board;
import com.hell.board.repository.BoardRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by mingook on 2016년7월 28일 (목).
 */
public class BoardController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Board> boards = BoardRepository.getInstance().findAll();
        req.setAttribute("boards", boards);

        req.getRequestDispatcher("board/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 세션 널체크따윈 없다..!!!
        String id = (String) req.getSession().getAttribute("id");
        String title = req.getParameter("title");
        String content = req.getParameter("content");

        Board board = new Board();
        board.setAuthor(id);
        board.setContent(content);
        board.setTitle(title);

        BoardRepository repository = BoardRepository.getInstance();
        repository.save(board);

        resp.sendRedirect("/board.do");
    }
}
