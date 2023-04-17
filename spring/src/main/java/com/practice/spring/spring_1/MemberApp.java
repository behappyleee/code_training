package com.practice.spring.spring_1;

import com.practice.spring.spring_1.dto.Member;
import com.practice.spring.spring_1.enums.Grade;
import com.practice.spring.spring_1.service.MemberService;
import com.practice.spring.spring_1.service.MemberServiceImpl;

public class MemberApp {

    // ������ �����ϴ� �� �˱� ���Ͽ� MemberApp �� ����
    // ������ �ڹٷ� �ڵ� ����
    // Application ���� ������ �׽�Ʈ �ϴ� �� �Ѱ谡 �վ� Junit �� �̿�
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "pitchu", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println("new Member = " + member.getName());
        System.out.println("find member = " + findMember.getName());

    }

}
