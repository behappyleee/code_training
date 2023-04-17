package com.practice.spring.spring_1.dao;

import com.practice.spring.spring_1.dto.Member;

import java.util.Optional;

public interface MemberRepository {

    void save(Member member);           // 회원 정보를 저장

    Member findById(Long memberId);     // 회원 정보를 찾음

    Optional<Member> findByName(String name);



}
