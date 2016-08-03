package com.hell.board.controller.member;

import com.hell.board.controller.Command;
import com.hell.board.model.Member;
import com.hell.board.repository.MemberRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mingook on 2016년8월 2일 (화).
 */
public class JoinCommand extends Command {
    public JoinCommand(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public void execute() throws IOException, ServletException {
        String id = request.getParameter("id");
        String password = request.getParameter("password");

        Member member = MemberRepository.getInstance().findById(id);

        if (member != null) {
            processDuplicateId();
        } else {
            processJoin(id, password);
        }
    }

    private void processJoin(String id, String password) throws ServletException, IOException {
        Member member = new Member();
        member.setId(id);
        member.setPassword(password);

        MemberRepository.getInstance().save(member);

        request.setAttribute("message", "가입에 성공했습니다.");
        RequestDispatcher dispatcher = request.getRequestDispatcher("alert.do");
        dispatcher.forward(request, response);
    }

    private void processDuplicateId() throws ServletException, IOException {
        request.setAttribute("message", "이미 존재하는 아이디 입니다.");
        RequestDispatcher dispatcher = request.getRequestDispatcher("alert.do");
        dispatcher.forward(request, response);
    }
}
