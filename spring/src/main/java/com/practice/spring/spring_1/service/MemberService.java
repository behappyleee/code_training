package com.practice.spring.spring_1.service;

import com.practice.spring.spring_1.dto.Member;

public interface MemberService {

    // service �� ���� ������ ���� �������̽��� ���� ��������� �ʾƵ� ������ �̻������δ�
    // ��� ��ü�� �������̽��� �ۼ��ϴ� ���� ����

    void join(Member member);

    Member findMember(Long memberId);
}
