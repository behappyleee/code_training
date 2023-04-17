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
        // 유저 회원가입 Test 코드 작성 다만 DIP / OCP 를 위반하고 있다.
        // given 이 주어 질 ?
        Member member = new Member (1L, "pitchu", Grade.VIP);
        
        // when 이렇게 했을 ?
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then 이렇게 된다.
        Assertions.assertThat(member).isEqualTo(findMember);

        // 검증 하는 내용
        // 조인 한거와 찾는게 똑같은지 확인이 필요 !!
    }

}
