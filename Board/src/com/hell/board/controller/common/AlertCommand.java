package com.hell.board.controller.common;

import com.hell.board.controller.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mingook on 2016년8월 3일 (수).
 */
public class AlertCommand extends Command {
    public AlertCommand(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public void execute() throws IOException, ServletException {
        request.getRequestDispatcher("WEB-INF/view/alert.jsp").forward(request, response);
    }
}
