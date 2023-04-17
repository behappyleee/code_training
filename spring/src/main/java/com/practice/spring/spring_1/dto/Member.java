package com.practice.spring.spring_1.dto;

import com.practice.spring.spring_1.enums.Grade;

public class Member {
    // Member 클래스 - 회원 등급, 회원 엔티티, 회원 서비스 interface, 회원 서비스 구현체, 회원 저장소 interface
    // 회원 저장소 구현체를 만듦
    // Meber 클래스에서는 id (인덱스), name(이름), grade(회원 등급) 을 멤버 변수로 가짐
    // 멤버 서비스 객체는 저장소에 의존함
    private Long id;
    private String name;
    private Grade grade;

    public Member(Long id, String name, Grade grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrade() {
        return this.grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

}
