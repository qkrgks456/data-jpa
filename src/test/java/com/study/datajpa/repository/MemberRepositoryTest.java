package com.study.datajpa.repository;

import com.study.datajpa.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @Test
    @Rollback(value = false)
    public void testMember() {
        Member member = new Member("memberA");
        Member save = memberRepository.save(member);

        Member findMember = memberRepository.findById(save.getId()).get();
        assertThat(findMember.getId()).isEqualTo(save.getId());
        assertThat(findMember.getUsername()).isEqualTo(save.getUsername());
        assertThat(findMember).isEqualTo(member);
    }
}