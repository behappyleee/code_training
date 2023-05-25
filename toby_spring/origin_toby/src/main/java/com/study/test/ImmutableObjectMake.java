package com.study.test;

import java.util.ArrayList;
import java.util.List;

public class ImmutableObjectMake {

    // 자바에서 불변 객체를 만드는 방법
    // Person 객체 Immutable 객체로 만들어 버리기
    // 생성자를 제외하고 상태를 바꿀만 한 메서드는 모두 제거
    
    // 객체를 Immutable 하게 만드는 방법
    // 1. 상태 변경 메서드 제거
    // 2. 모든 객체 필드는 private final 지정
    // 3. 클래스 상속 금지
    // 4. mutable 객체의 레퍼런스 금지

    // 외부에 노출 되는 상태 정보는 immutable 하지만
    // 내부에서만 관리되는 상태는 mutable 한 경우에도
    // immutable 객체라고 부르기도 한다.
    // 이떄는 thread-safe 하지 않을 수도 있음

}

final class Person {  // 자녀 클래스의 메서드 override 금지, 즉 클래스 상속 금지, 자바 문법 상 final 클래스 설정 시 상속이 절대 불가
    // private String name;    // name 이라는 상태가 처음 초기화가 된 후 아예 값을 바꿀 수 없게 설정
    private final String name;    // 불변 값을 만들기 위하여 모든 필드를 final 키워드를 설정, final 은 한번 값이 할당 되면 절대 바뀔 수 없다는 뜻

    // 만약에 List(Collection 개념) 를 필드로 가지면
    // List 와 List 에 있는 mutable 객체 모두 방어적 복사를 해주어야 한다.
    private final List <RGB> rgbs;       // RGBs Mutable

    public Person(String name, List<RGB> rgbs) {
        this.name = name;
        this.rgbs = copy(rgbs);
    }

    public String getName() {
        return this.name;
    }


// 불변 객체를 만들기 위하여 해당 메서드 주석처리 (객체의 상태 값을 바꾸는 것은 생성자를 제외 하고는 없어야 함)
//    public void setName(String name) {
//        this.name = name;
//    }

    // List 필드를 가지는 불변 객체
    public List<RGB> getRGBs() {
        return copy(rgbs);
    }

    // Collection 객체는 모두 객체를 새로 생성하여 Return
    private List<RGB> copy(List<RGB> rgbs) {
        List<RGB> cps = new ArrayList<RGB>();
        // 객체를 모두 생성을 해주어 return
        rgbs.forEach(o -> cps.add(new RGB(o.r, o.g, o.b)));
        return cps;
    }

    // 만약 List 가 Immutable 객체 일 시 아래 처럼 내부적 으로는 그냥 얕은 복사만 시켜줌 얕은 복사는
    // 복사 전과 복사 후가 같은 주소 값을 가리크면 해당 복사는 얕은 복사임
    // 주소값 참조 값만 넘겨주는 것임
//    private List<RGB> copy(List<RGB> rgbs) {
//        return new ArrayList<>(rgbs);
//    }

}
