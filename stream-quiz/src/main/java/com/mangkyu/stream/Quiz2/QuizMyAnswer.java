package com.mangkyu.stream.Quiz2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuizMyAnswer {

    private static List<String> WORDS = Arrays.asList("TONY", "a", "hULK", "B", "america", "X", "nebula", "Korea");

    public static Map<String, Integer> first() {
        Map<String, Integer> countStr = new HashMap<String, Integer>();
        WORDS.stream()
                .forEach((word) -> {
                    countStr.put(word, word.length());
                });
        return countStr;
    }

    public static String second() {
        StringBuilder sb = new StringBuilder();
        WORDS.stream()
                .filter((word) -> word.length() > 1)
                .map(String::toUpperCase)
                .forEach((word) -> {
                    sb.append(word + " ");
                });
        return sb.toString();
    }


    public static void main(String[] args) {
        // 2.1 List에 저장된 단어들의 접두사가 각각 몇개씩 있는지 Map<String, Integer>으로 변환하여라.
        Map<String, Integer> answer1 = first();

        System.out.println("ANSWER 1 : " + answer1);

        // 2.2 List에 저장된 단어들 중에서 단어의 길이가 2 이상인 경우에만, 모든 단어를 대문자로 변환하여 스페이스로 구분한 하나의 문자열로 합한 결과를 반환하여라.
        String answer2 = second();
        System.out.println("ANSWER 2 String Check : " + answer2);

    }

}
