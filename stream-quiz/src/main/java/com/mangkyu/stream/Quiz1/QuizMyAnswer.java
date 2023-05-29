package com.mangkyu.stream.Quiz1;

import com.opencsv.CSVReader;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class QuizMyAnswer {

    public static void main(String[] args) throws IOException {
        // Quiz Answer
        // 1-1 각 취미를 선호하는 인원이 몇 명인지 계산하여라.
        List<String[]> csvLines1 = readCsvLines();
        csvLines1.stream()
                .forEach((csvLine) -> {
                    String csvLineCheck = csvLine.toString();
                    System.out.println("CSV LINE CHECK : " + csvLineCheck);
                    System.out.println("CSV LINE NAME CHECK : " + csvLine);
                });

        // 1-2 각 취미를 선호하는 정씨 성을 갖는 인원이 몇 명인지 계산하여라.
        List<String[]> csvLines2 = readCsvLines();
//        int count = csvLines2.stream()
//                .filter()


        // 1-3 소개 내용에 '좋아'가 몇번 등장하는지 계산하여라.
        List<String[]> csvLines3 = readCsvLines();


    }

    private static List<String[]> readCsvLines() throws IOException {
        CSVReader csvReader = new CSVReader(new FileReader(QuizMyAnswer.class.getResource("/user.csv").getFile()));
        csvReader.readNext();
        return csvReader.readAll();
    }

}
