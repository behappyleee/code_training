package com.mangkyu.stream.Quiz6;

import java.util.*;
import java.util.stream.Collectors;

public class QuizMyAnswer {

    private static final Student[] stuArr = new Student[]{
            new Student("나자바", true, 1, 1, 300),
            new Student("김지미", false, 1, 1, 250),
            new Student("김자바", true, 1, 1, 200),
            new Student("이지미", false, 1, 2, 150),
            new Student("남자바", true, 1, 2, 100),
            new Student("안지미", false, 1, 2, 50),
            new Student("황지미", false, 1, 3, 100),
            new Student("강지미", false, 1, 3, 150),
            new Student("이자바", true, 1, 3, 200),
            new Student("나자바", true, 2, 1, 300),
            new Student("김지미", false, 2, 1, 250),
            new Student("김자바", true, 2, 1, 200),
            new Student("이지미", false, 2, 2, 150),
            new Student("남자바", true, 2, 2, 100),
            new Student("안지미", false, 2, 2, 50),
            new Student("황지미", false, 2, 3, 100),
            new Student("강지미", false, 2, 3, 150),
            new Student("이자바", true, 2, 3, 200)
    };

    public static Map<String, Object> underScoreStudent() {
        Map<String, Object> stuMap = new HashMap<String, Object>();
        
        // 150 점 미만 학생 들 까지는 filtering 함 150 점 미만인 학생들을 거름
        Arrays.asList(stuArr)
                .stream()
                .filter((student) -> {
                   return student.getScore() < 150;
                });


        return stuMap;
    }

    public static Map<Integer, Map<Integer, Integer>> banScorePerHak() {
        Map<Integer, Map<Integer, Integer>> scores = new HashMap<Integer, Map<Integer, Integer>>();

//        Arrays.asList(stuArr)
//                .stream()
//                .collect(Collectors.partitioningBy(Student::getScore))
//                .toString();
//        Arrays.asList(stuArr)
//                .stream()
//                .reduce();

        return scores;
    }

    public static void main(String[] args) {
        // 6-1 stuArr에서 불합격(150점 미만)한 학생의 수를 남자와 여자로 구별하여라. (Boolean, List)
        Map<String, Object> stu = underScoreStudent();

        // 6-2 각 반별 총점을 학년 별로 나누어 구하여라 (Map<Integer, Map<Integer, Integer>>)
        Map<Integer, Map<Integer, Integer>> hakScore = banScorePerHak();




    }

}
