package com.hell.board.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mingook on 2016년8월 2일 (화).
 */
public class Controller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGetAndPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGetAndPost(request, response);
    }

    private void doGetAndPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        switch (request.getRequestURI()) {
            case "/":
                request.getRequestDispatcher("WEB-INF/view/board/list.jsp").forward(request, response);
                break;
            case "login.do":
                break;
            case "join.do":
                break;
        }
    }
}
