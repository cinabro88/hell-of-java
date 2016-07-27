package com.hell.board.repository;

/**
 * Created by mingook on 2016년7월 27일 (수).
 */

import com.hell.board.model.Member;
import com.sun.xml.internal.rngom.parse.host.Base;

import java.util.List;

public class MemberRepository extends BaseRepository<Member> {

    private static MemberRepository instance;

    private MemberRepository() {
    }

    public static MemberRepository getInstance() {
        if (instance == null) {
            instance = new MemberRepository();
        }
        return instance;
    }

    public Member findById(String id) {
        for (Member data : datas) {
            if (data.getId().equals(id)) {
                return data;
            }
        }

        return null;
    }
}
