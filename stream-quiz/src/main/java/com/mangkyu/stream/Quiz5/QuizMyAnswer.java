package com.mangkyu.stream.Quiz5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

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

    public static int maxStrLength() {
        List<String> arrList = new ArrayList(Arrays.asList(STRING_ARR));
        String maxStr = arrList.stream()
                .map((arr) -> {
                    return String.valueOf(arr.length());
                })
                .max(String::compareTo)
                .get()
                .toString();
        return Integer.parseInt(maxStr);
    }

    public static List<Integer> lottoNum() {
        List<Integer> lottos = new ArrayList<Integer>();
        AtomicInteger ai = new AtomicInteger();
        Random rd = new Random();
        // TODO
        // lotto 번호를 정렬 1 ~ 45 까지 ...
        return null;
    }

    // TODO
    // 두개의 주사위를 던져 합이 6인 경우 ...
    public static List<Integer> diceSum() {
        List<Integer> sum = new ArrayList<Integer>();
        IntStream.range(1,6)
                .filter((num) -> {
                    return true;
                });
        return sum;
    }

    public static void main(String[] args) {
        // 5.1 모든 문자열의 길이를 더한 결과를 출력하여라.
        int totalLength = totalLength();
        System.out.println("STR TOTAL LENGTH : " + totalLength);

        // 5.2 문자열 중에서 가장 긴 것의 길이를 출력하시오.
        int strMaxLength = maxStrLength();
        System.out.println("STR MAX LENGTH DATA CHECK : " + strMaxLength);

        //  5.3 임의의 로또번호(1~45)를 정렬해서 출력하시오.
        List<Integer> lottos = lottoNum();

        // 5.4 두 개의 주사위를 굴려서 나온 눈의 합이 6인 경우를 모두 출력하시오.
        diceSum();




    }

}
