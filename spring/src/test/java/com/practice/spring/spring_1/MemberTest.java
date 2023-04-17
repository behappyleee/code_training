package com.practice.spring.spring_1;

import com.practice.spring.spring_1.dto.Member;
import com.practice.spring.spring_1.enums.Grade;
import com.practice.spring.spring_1.service.MemberService;
import com.practice.spring.spring_1.service.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        // ���� ȸ������ Test �ڵ� �ۼ� �ٸ� DIP / OCP �� �����ϰ� �ִ�.
        // given �� �־� �� ?
        Member member = new Member (1L, "pitchu", Grade.VIP);
        
        // when �̷��� ���� ?
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then �̷��� �ȴ�.
        Assertions.assertThat(member).isEqualTo(findMember);

        // ���� �ϴ� ����
        // ���� �Ѱſ� ã�°� �Ȱ����� Ȯ���� �ʿ� !!
    }

}
