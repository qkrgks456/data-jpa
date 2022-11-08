package com.study.datajpa.repository;

import com.study.datajpa.domain.Member;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import java.util.List;

@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {

    private final EntityManager entityManager;

    @Override
    public List<Member> findMemberCustom() {
        return entityManager.createQuery("select m from Member m").getResultList();
    }
}
