package com.hell.board.controller.board;

import com.hell.board.controller.Command;
import com.hell.board.model.Board;
import com.hell.board.repository.BoardRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mingook on 2016년8월 2일 (화).
 */
public class WriteBoardCommand extends Command {
    public WriteBoardCommand(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public void execute() throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");

        // 세션 널체크따윈 없다..!!!
        String id = (String) request.getSession().getAttribute("id");
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        Board board = new Board();
        board.setAuthor(id);
        board.setContent(content);
        board.setTitle(title);

        System.out.println(" >>>>>>>>>> Write");
        System.out.println("id[" + id + "], title[" + title + "], content[" + content + "]");

        BoardRepository repository = BoardRepository.getInstance();
        board.setIndex(repository.findAll().size() + 1);
        repository.insert(board);

        response.sendRedirect("/board.do");
    }
}
