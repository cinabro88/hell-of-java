package com.hell.board.service;

import com.hell.board.model.Member;
import com.hell.board.repository.MemberRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by mingook on 2016년7월 30일 (토).
 */
public class MemberService {
    // TODO 1. 아이디 중복체크는 서비스에서 해야하는걸까?? 이거에 따라서 view에 화면이 달라질텐데, 그냥 boolean만 리턴해 주면 될까?
    // 2. controller까지 요청이 도달했다는거는 이미 프론트엔드에서 데이터 validation을 하고 난 후이니까 그냥 바로 저장을 할까?
    public boolean insertMember(Member member) {
        if (checkDupicateId(member.getId())) {
            return false;
        }

        MemberRepository.getInstance().insert(member);
        return true;
    }

    private boolean checkDupicateId(String id) {
        Member findMember = MemberRepository.getInstance().findById(id);
        return findMember != null;
    }

    public boolean login(String id, String password) {
        Member member = MemberRepository.getInstance().findById(id);
        return member != null && member.getPassword().equals(password);
    }
}
