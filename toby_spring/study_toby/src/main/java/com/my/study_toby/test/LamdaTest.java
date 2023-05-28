package com.my.study_toby.test;

public class LamdaTest {

    // Lambda Function --> 익명 함수임
    // 람다 대수는 수학에서 사용하는 함수를 보다 단순하게 표현하는 방법

    public static void main(String[] args) {
        TestI ti = () -> {
            String test = "Check String";
            return test;
        };

        TestI ti2 = new TestI() {
            @Override
            public String test() {
                String returnTest = "This is Return Lambda Test";
                return returnTest;
            }
        };

        TestI2 testi = (String tiPram , int tiParam) -> {
            String printParam = tiPram + tiParam;
            return printParam;
        };

        System.out.println("JAVA LAMBDAT FUNCTION EXECUTE : " + testi.paramPrint("TEST", 777));

//        testi("TTTT", 9999);
//        TestI2 ti222 = new TestI2("ttt", 33);

        OnlyOne onlyone =  (int a, int b, String c) -> {
            String concatParam = a + " " + b + " " + c;
            return concatParam;
        };

        System.out.println("ONLY ONE PARAM LAMBDA DATA CHECK : " + onlyone.checkParam(3, 2, "THIS IS TEST"));
        
        // Function Interface 그냥 default method 사용 시 해당 메서드처럼 call
        // System.out.println("ONLY ONE DEFAULT METHOD CHECK : " + onlyone.testM(3 , "THIS IS DEFAULT METHOD"));

        // Interface 에 static 메서드 사용 시 해당 예제 처럼 접근
        // System.out.println("ONLY ONE DEFAULT METHOD CHECK : " + OnlyOne.testM(3 , "THIS IS DEFAULT METHOD"));

    }
}

@FunctionalInterface
interface TestI {
    public String test();
}

@FunctionalInterface
interface TestI2 {
    public String paramPrint(String a, int b);
}

@FunctionalInterface
interface OnlyOne {
    public String checkParam(int a, int b, String c);

    static public String testM(int a, String c) {
        return c;
    };
}



