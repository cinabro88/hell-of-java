package com.hell.board.controller.member;

import com.hell.board.controller.Command;
import com.hell.board.model.Member;
import com.hell.board.repository.MemberRepository;
import com.hell.board.service.MemberService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mingook on 2016년8월 2일 (화).
 */
public class JoinCommand extends Command {
    private MemberService memberService;

    public JoinCommand(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
        memberService = new MemberService();
    }

    @Override
    public void execute() throws IOException, ServletException {
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        Member member = new Member(id, password);

        if (memberService.insertMember(member)) {
            onJoinSucceed();
        } else {
            onJoinFailedByDuplicateId();
        }
    }

    private void onJoinSucceed() throws ServletException, IOException {
        request.setAttribute("message", "가입에 성공했습니다.");
        RequestDispatcher dispatcher = request.getRequestDispatcher("alert.do");
        dispatcher.forward(request, response);
    }

    private void onJoinFailedByDuplicateId() throws ServletException, IOException {
        request.setAttribute("message", "이미 존재하는 아이디 입니다.");
        RequestDispatcher dispatcher = request.getRequestDispatcher("alert.do");
        dispatcher.forward(request, response);
    }
}
