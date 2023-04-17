package com.practice.spring.spring_1.service;

import com.practice.spring.spring_1.dto.Member;

public interface MemberService {

    // service 는 변동 사항이 없어 인터페이스를 따로 만들어주지 않아도 되지만 이상적으로는
    // 모든 구체에 인터페이스를 작성하는 것이 좋음

    void join(Member member);

    Member findMember(Long memberId);
}
