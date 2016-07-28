package com.hell.board.controller;

import com.hell.board.model.Member;
import com.hell.board.repository.MemberRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("message", "asdfasdf");
        req.getRequestDispatcher("alert.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String password = req.getParameter("password");
        String action = req.getParameter("action");

        switch (action) {
            case "login":
                login(req, resp, id, password);
                break;
            case "join":
                goJoinPage(resp);
                break;
        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp, String id, String password) throws IOException, ServletException {
        Member member = MemberRepository.getInstance().findById(id);
        if (member != null && member.getPassword().equals(password)) {
            onLoginSucceed(req, resp, id);
        } else {
            onLoginFailed(req, resp);
        }
    }

    private void onLoginFailed(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("message", "아이디, 비밀번호를 확인해주세요.");
        req.getRequestDispatcher("alert.jsp").forward(req, resp);
    }

    private void onLoginSucceed(HttpServletRequest req, HttpServletResponse resp, String id) throws IOException {
        HttpSession session = req.getSession();
        session.setAttribute("id", id);

        resp.sendRedirect("/board.do");
    }

    private void goJoinPage(HttpServletResponse response) throws IOException {
        response.sendRedirect("/join.jsp");
    }
}
