package com.board.service;

import com.board.exception.IdPasswordNotMatchingException;
import com.board.model.Member;
import com.board.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by mingook on 2016년9월 20일 (화).
 */
public class LoginService {
    @Autowired
    private MemberRepository memberRepository;

    public void login(String id, String password) {
        Member member = memberRepository.findById(id);
        if (member == null) {
            throw new IdPasswordNotMatchingException();
        }

        if (!member.getPassword().equals(password)) {
            throw new IdPasswordNotMatchingException();
        }
    }
}
