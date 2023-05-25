package com.study.test;

public class StringTest {

    public static void main(String[] args) {
        // 자바의 String (easyCode 도 쉬운 코드 값을 가르키도 sameRef 도 값을 가르키게 됨)
        String easyCode = "THIS IS EASY CODE";
        String sameRef = easyCode;

        System.out.println(easyCode == sameRef);    // 값은 객체의 값을 비교하므로 TRUE

        easyCode = "THIS IS CHANGE OBJECT VALUE";   // 해당 String 변수를 재할당을 하게 되면 값이 메모리에 다시 할당이 됨

        System.out.println(easyCode == sameRef);    // easyCode 는 새로운 재 할당한 변수 값을 가르키고 sameRef 는 처음에 할당한 값을 가르키면서
        // "THIS IS EASY CODE"; 와 "THIS IS CHANGE OBJECT VALUE";  비교를 하는 것이므로 객체가 서로 다른 값을 가르키므로 서로 다름

        // 자바에서 String 은 객체가 절대 변하지 않는 불변 객체임 Immutable 객체


    }

}
