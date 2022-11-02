package com.study.datajpa.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class MemberTest {

    @PersistenceContext
    EntityManager entityManager;

    @Test
    @Rollback(value = false)
    public void testEntity() {
        Team teamA = new Team("teamA");
        Team teamB = new Team("teamB");
        entityManager.persist(teamA);
        entityManager.persist(teamB);
        Member member1 = new Member("member1", 10, teamA);
        Member member2 = new Member("member2", 20, teamA);
        Member member3 = new Member("member3", 30, teamB);
        Member member4 = new Member("member4", 40, teamB);
        entityManager.persist(member1);
        entityManager.persist(member2);
        entityManager.persist(member3);
        entityManager.persist(member4);

        entityManager.flush();
        entityManager.clear();

        List<Member> memberList = entityManager.createQuery("select m from Member m", Member.class)
                .getResultList();
        assertThat(member1.getId()).isEqualTo(memberList.get(0).getId());
        assertThat(member2.getId()).isEqualTo(memberList.get(1).getId());
        assertThat(member3.getId()).isEqualTo(memberList.get(2).getId());
        assertThat(member4.getId()).isEqualTo(memberList.get(3).getId());

    }

}