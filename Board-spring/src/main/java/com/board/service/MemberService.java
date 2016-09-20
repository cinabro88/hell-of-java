package com.board.service;

import com.board.exception.IdPasswordNotMatchingException;
import com.board.model.Member;
import com.board.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by mingook on 2016년7월 30일 (토).
 */
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public boolean insertMember(Member member) {
        if (checkDupicateId(member.getId())) {
            return false;
        }

        memberRepository.insert(member);
        return true;
    }

    private boolean checkDupicateId(String id) {
        Member findMember = memberRepository.findById(id);
        return findMember != null;
    }
}
