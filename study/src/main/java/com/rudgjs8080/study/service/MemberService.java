package com.rudgjs8080.study.service;

import com.rudgjs8080.study.domain.Member;
import com.rudgjs8080.study.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Transactional(readOnly = true)
 * 영속성 컨텍스트
 * readOnly = true : 데이터의 변경이 없는 읽기 전용 메서드에 사용
 * 영속성 컨텍스트를 플러시 하지 않으므로 약간의 성능 향상(읽기 전용에는 다 적용)
 * 데이터베이스 드라이버가 지원하면 DB에서 성능 향상
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

//    @Autowired // 스프링 필드 주입 대신에 생성자 주입을 사용하자
//    MemberRepository memberRepository;

    private final MemberRepository memberRepository;


    // 회원가입
    @Transactional //변경
    public Long join(Member member){

        validateDuplicateMember(member); // 중복 회원 검증

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member){
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다");
        }
    }

    // 전체 회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId){
        return memberRepository.findOne(memberId);
    }

}
