package com.practice.spring.spring_1.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Controller
public class SpringController {

    // 스프링은 하나의 기술이 아니라 여러 기술들의 모음
    // 필수적인 기술은 스프링 프레임워크, 스프링 부트
    // 스프링부트 특징은 스프링을 편리하게 사용할 수 있도록 지원, Tomcat 과 같은 웹 서버를 내장하여 별도의 웹 서버를
    // 설치하지 않아도 됨, starter 를 통하여 손쉬은 빌드가 가능, 버전에 맞는 외부 라이브러리를 알아서 가져옴
    // 스프링은 객체 지향 언어인 자바 언어 기반의 프레임 워크임, 객체 지향이 가진 특징을 가장 크게 살릴 수 있는 것이 스프링임

    // 인터페이스를 잘 설계 하는 것이 좋은 객체 지향 프로그램

    // 비즈니스 요구 사항과 설계
    // 회원 - 회원을 가입하고 조회, 회원은 일반과 VIP 두가지 등급, 회원 데이터는 자체 DB를 구축할 수 있도 외부 시스템과 연동

    // 주문과 할인 정책
    // 회원은 상품을 주문할 수 있다. 회원 등급에 따라 할인 정책 적용, 할인 정책은 모든 VPI 는 1000 원을 할인해주는 고정 금액 할인을 적용
    // 할인 정책은 변경 가능성이 높음 회사의 기본 할인 정책을 아직 정하지 못했고 오픈 직전까지 고민을 미루고 싶음
    // 최악의 경우 할인을 적용하지 않을 수 있음

}
