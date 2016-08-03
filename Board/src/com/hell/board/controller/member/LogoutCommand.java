package com.hell.board.controller.member;

import com.hell.board.controller.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by mingook on 2016년8월 3일 (수).
 */
public class LogoutCommand extends Command {
    public LogoutCommand(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public void execute() throws IOException, ServletException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        response.sendRedirect("/");
    }
}
