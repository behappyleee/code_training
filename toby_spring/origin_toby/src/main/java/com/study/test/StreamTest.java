package com.study.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class StreamTest {

    public static void main(String[] args) {
        // Java Stream 실습
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

//      1. 2011년에 일어난 모든 트랜잭션을 찾아 값을 오름차순으로 정리하시오.
        // My Answer
//        List<Transaction> filteredTransactions = transactions.stream().filter((item) -> {
//            int year = item.getYear();
//            return (year == 2011);
//        }).sorted().collect(toList());

        // Answer
        List<Transaction> transactions1 = transactions.stream()
                        .filter((transaction) -> transaction.getYear() == 2011)
                        .sorted(comparing(Transaction::getValue))
                        .collect(toList());

        System.out.println("TRANSACTION 1 FILTERED DATA CHECK  : " + transactions1);
        System.out.println("AFTER FILTERED TRANSACTIONS : " + transactions.size());

//        2. 거래자가 근무하는 모든 도시를 중복없이 나열하시오
        // MyAnswer
        List<String> filteredCity = transactions.stream()
                .map((transaction) -> transaction.getTrader().getCity())
                .distinct()
                .collect(toList());

        System.out.println("THIS IS CITY FILTERED DE DUPLICATE : " + filteredCity);

        // Answer
        List<String> transactions2 = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .collect(toList());
        System.out.println(transactions2);

//        3. 케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하시오 Cambridge
        // MyAnswer
        List<String> filteredName = transactions.stream()
                .filter((transaction) -> transaction.getTrader().getCity().equals("Cambridge"))
                .map((transaction) -> transaction.getTrader().getName())
                .sorted()
                .collect(toList());

        System.out.println("FILTERED STRING NAME IN CAMBRIDGE : " + filteredName);

        // ANSWER
        List<Trader> transaction4 =
                transactions.stream()
                        .filter((transcation) -> transcation.getTrader().getName().equals("Cambridge"))
                        .map(Transaction::getTrader)
                        .sorted(comparing(Trader::getName))
                        .distinct()
                        .collect(toList());

//        4. 모든 거래자의 이름을 알파벳순으로 정리해서 반환하시오
        // My Answer
        List<String> filteredNameTest = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .sorted()
                .distinct()
                .collect(toList());

        System.out.println("FILTERED ONLY NAME CHECK : " + filteredNameTest);

        // ANSWER
        String transcation4 = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (n1,n2)->n1+n2);
        System.out.println(transcation4);


//        5. 밀라노에 거래자가 있는가?
//        boolean isExistMilanoTrader = transactions.forEach((transaction) -> {
//
//        });

        // My Answer
        boolean isExistMilanoTrader = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .anyMatch(Predicate.isEqual("Milano"));

        System.out.println("IS EXIST MILANOT DATA TEST CHECK : " + isExistMilanoTrader);

        // Answer
        boolean transaction5 = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milano"));

//        6. 케임브리지에 거주하는 거래자의 모든 트랜잭션값을 출력하시오
        // MyAnswer
        transactions.stream()
                .filter((transaction) -> transaction.getTrader().getCity().equals("Cambridge"))
                .forEach(System.out::println);

        transactions.stream()
                .filter((transaction) -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        // Answer
        List<Integer> transaction6 = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .collect(toList());

//        7. 전체 트랜잭션 중 최댓값은 얼마인가?
        // My Answer
        String maxValue = transactions.stream()
                .max(comparing(Transaction::getValue)).toString();

        System.out.println("MAX VALUE CHECK NO 7 : " + maxValue);

        // Answer
        Optional<Integer> transaction7 = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);

        if(transaction7.isPresent()){
            System.out.println(transaction7.get());
        }

//        8. 전체 트랜잭션 중 최솟값은 얼마인가?
        String minValue = transactions.stream()
                .min(comparing(Transaction::getValue)).toString();

        System.out.println("MIN VALUE CHECK NO 8 : " + minValue);

        // Answer
        Optional<Integer> transaction8 = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::min);
        if(transaction8.isPresent()){
            System.out.println(transaction8.get());
        }



    }
    
}


class Trader {
    private final String name;
    private final String city;

    public Trader(String n, String c) {
        this.name = n;
        this.city = c;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "trader:" + this.name + " in " + this.city;
    }
}

class Transaction {
    private final Trader trader;
    private final int year;
    private final int value;

    public Transaction(Trader trader, int year, int value){
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return trader;
    }
    public int getYear(){
        return year;
    }
    public int getValue(){
        return value;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "trader=" + trader +
                ", year=" + year +
                ", value=" + value +
                '}';
    }
}

