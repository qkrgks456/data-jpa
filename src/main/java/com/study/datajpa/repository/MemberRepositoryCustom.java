package com.study.datajpa.repository;

import com.study.datajpa.domain.Member;

import java.util.List;

public interface MemberRepositoryCustom {
    List<Member> findMemberCustom();
}
