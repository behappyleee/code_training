package com.study.test;

public class OverFlowTest {

    public static void main(String[] args) {
        // TODO
        // Overflow Test 할 수 있는 방법 찾아 보기 (StackOverFlow or HeapOverFlow)
//        while(true) {
//            String a = new String("OverFlowTest");
//            callTestMethod();
//        }




    }

    public static void callTestMethod() {

    }
}

interface TestI {

    default public String printTest() {
        System.out.println("This is Test Method");
        return null;
    };

}