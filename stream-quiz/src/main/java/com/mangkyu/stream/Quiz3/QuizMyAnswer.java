package com.mangkyu.stream.Quiz3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class QuizMyAnswer {

        private static final List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        private static final List<Integer> numbers2 = Arrays.asList(3, 4);

        private static int maxNum = 0;

        public static int[][] first() {
            int[][] answerArray = new int[(numbers1.size() * numbers2.size())][2];
            AtomicInteger arrayIndex = new AtomicInteger();
            IntStream.range(0, numbers1.size())
                    .forEach((index1) -> {
                        int num1 = numbers1.get(index1);
                        IntStream.range(0, numbers2.size())
                                .forEach((index2) -> {
                                    int num2 = numbers2.get(index2);
                                    int nextIndex = arrayIndex.getAndIncrement();
                                    answerArray[nextIndex][0] = num1;
                                    answerArray[nextIndex][1] = num2;
                                });
                    });
        return answerArray;
    }

    public static int second() {
        // AtomicInteger maxNum = new AtomicInteger(0);
        numbers1.stream()
            .forEach((num1) -> {
                numbers2.stream()
                    .forEach((num2) -> {
                        int mulNum = (num1 * num2);
                        if(mulNum > maxNum) {
                            maxNum = mulNum;
                        }
                });
        });
        return maxNum;
    }


    public static void main(String[] args) {
        // 3.1 모든 숫자 쌍의 배열 리스트를 반환하여라.
        // ex) numbers1 = [1,2,3], numbers2 = [3,4] -> [(1,3), (1,4), (2,3), (2,4), (3,3), (3,4)]
        int[][] first = first();

        // 3.2 모든 숫자 쌍의 곱이 가장 큰 값을 반환하여라.
        // ex) numbers1 = [1,2,3], numbers2 = [3,4] -> 12
        int getMaxNum = second();
        System.out.println("GET MAX SECOND NUM : " + getMaxNum);

        numbers1.stream()
                .flatMap((number) -> {
                    System.out.println("NUM CHECK : " + number);
                    return null;
                });



    }

}
