package com.hell.board.controller;

import com.hell.board.model.Member;
import com.hell.board.repository.MemberRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mingook on 2016년7월 27일 (수).
 */
public class JoinController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/view/member/join.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String password = req.getParameter("password");

        Member member = MemberRepository.getInstance().findById(id);

        if (member != null) {
            processDuplicateId(req, resp);
        } else {
            processJoin(req, resp, id, password);
        }
    }

    private void processJoin(HttpServletRequest req, HttpServletResponse resp, String id, String password) throws ServletException, IOException {
        Member member = new Member();
        member.setId(id);
        member.setPassword(password);

        MemberRepository.getInstance().save(member);

        req.setAttribute("message", "가입에 성공했습니다.");
        RequestDispatcher dispatcher = req.getRequestDispatcher("alert.jsp");
        dispatcher.forward(req, resp);
    }

    private void processDuplicateId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("message", "이미 존재하는 아이디 입니다.");
        RequestDispatcher dispatcher = req.getRequestDispatcher("alert.jsp");
        dispatcher.forward(req, resp);
    }
}
