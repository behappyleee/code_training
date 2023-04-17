package com.practice.spring.spring_1;

import com.practice.spring.spring_1.dto.Member;
import com.practice.spring.spring_1.enums.Grade;
import com.practice.spring.spring_1.service.MemberService;
import com.practice.spring.spring_1.service.MemberServiceImpl;

public class MemberApp {

    // 실제로 동작하는 지 알기 위하여 MemberApp 을 생성
    // 순수한 자바로 코드 생성
    // Application 으로 로직을 테스트 하는 건 한계가 잇어 Junit 을 이용
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "pitchu", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println("new Member = " + member.getName());
        System.out.println("find member = " + findMember.getName());

    }

}
