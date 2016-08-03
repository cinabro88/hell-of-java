package com.hell.board.controller.board;

import com.hell.board.controller.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by mingook on 2016년8월 2일 (화).
 */
public class WriteBoardPageCommand extends Command {
    public WriteBoardPageCommand(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public void execute() throws IOException, ServletException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("id") == null) {
            request.setAttribute("message", "로그인한 사용자만 글을 쓸 수 있습니다.");
            request.getRequestDispatcher("alert.do").forward(request, response);
            return;
        }
        request.getRequestDispatcher("WEB-INF/view/board/write.jsp").forward(request, response);
    }
}
