package com.hell.board.controller.board;

import com.hell.board.controller.Command;
import com.hell.board.model.Board;
import com.hell.board.repository.BoardRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by mingook on 2016년8월 2일 (화).
 */
public class BoardListCommand extends Command {
    public BoardListCommand(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public void execute() throws IOException, ServletException {
        List<Board> boards = BoardRepository.getInstance().findAll();
        request.setAttribute("boards", boards);

        System.out.println();
        System.out.println(">>> board <<<");
        for (Board board : boards) {
            System.out.println("id[" + board.getAuthor() + "], title[" + board.getTitle() + "], content[" + board.getContent() + "]");
        }

        request.getRequestDispatcher("WEB-INF/view/board/list.jsp").forward(request, response);
    }
}
