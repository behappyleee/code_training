package com.mangkyu.stream.Quiz5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuizMyAnswer {

    private static final String[] STRING_ARR = {"aaa", "bb", "c", "dddd"};

    public static int totalLength () {
        List<String> arrList = new ArrayList(Arrays.asList(STRING_ARR));
        String sumStr = arrList.stream()
                .reduce((a, b) -> {
                    return (a+b);
                }).get().toString();
        return sumStr.length();
    }


    public static void main(String[] args) {
        // 5.1 모든 문자열의 길이를 더한 결과를 출력하여라.
        int totalLength = totalLength();
        System.out.println("STR TOTAL LENGTH : " + totalLength);

        // TODO
        // 5.2 부터 실행 하기 !!!!
        // TODO Stream 예제 복습 하기 !
        // commit push 확인 필요



    }

}
