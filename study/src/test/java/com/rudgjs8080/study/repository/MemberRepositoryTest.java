package com.rudgjs8080.study.repository;

import com.rudgjs8080.study.domain.Member;
import com.rudgjs8080.study.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;
    @Autowired MemberService memberService;

    @Test
    public void 회원가입() throws Exception {
        //Given
        Member member1 = new Member();
        member1.setName("one");

        Member member2 = new Member();
        member2.setName("two");

        // wheh
        memberService.join(member1);
        memberService.join(member2); // 예외가 발생해야 한다

        //fail("예외가 발생해야한ㄷ가");

    }

}