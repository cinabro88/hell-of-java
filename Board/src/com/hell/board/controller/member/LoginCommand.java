package com.hell.board.controller.member;

import com.hell.board.controller.Command;
import com.hell.board.model.Member;
import com.hell.board.repository.MemberRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by mingook on 2016년8월 2일 (화).
 */
public class LoginCommand extends Command {

    public LoginCommand(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public void execute() throws ServletException, IOException {
        String id = request.getParameter("id");
        String password = request.getParameter("password");

        Member member = MemberRepository.getInstance().findById(id);
        if (member != null && member.getPassword().equals(password)) {
            onLoginSucceed(id);
        } else {
            onLoginFailed();
        }
    }

    private void onLoginFailed() throws ServletException, IOException {
        request.setAttribute("message", "아이디, 비밀번호를 확인해주세요.");
        request.getRequestDispatcher("alert.jsp").forward(request, response);
    }

    private void onLoginSucceed(String id) throws IOException {
        HttpSession session = request.getSession();
        session.setAttribute("id", id);
        response.sendRedirect("board.do");
    }
}
