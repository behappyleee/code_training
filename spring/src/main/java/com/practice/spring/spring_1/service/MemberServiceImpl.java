package com.practice.spring.spring_1.service;

import com.practice.spring.spring_1.dao.MemberRepository;
import com.practice.spring.spring_1.dao.MemoryMemberRepository;
import com.practice.spring.spring_1.dto.Member;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
