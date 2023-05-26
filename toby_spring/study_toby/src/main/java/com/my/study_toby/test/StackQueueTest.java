package com.my.study_toby.test;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class StackQueueTest {
    // ADT (Abstract Data Type) - 추상자료형 개념 적으로 어떤 동작이 있는지만 정의, 구현에 대해서는 다루지 않음
    // DS (Data Structure)  - 자료구조, ADT 에서 정의 된 동작을 실제로 구현한 것

    // Stack
    // LIFO (Last In First Out) - push / pop / peek => 스택 주요 동작
    // push 하면 값이 들어가고 pop 을 하면 가장 마지막 값이 나옴 peek 은 가장 마지막 값을 확인을 함

    // Queue
    // FIFO (First In First Out) -  enqueue / dequeue / peek
    // enqueue 는 값을 집어 넣음, dequeue 는 가장 첫번 째 값을 꺼냄 peek 은 가장 첫번쨰 값을 확인


    // Stack 사용 사례 - Stack Frame, Stack Memory 구조
    // Queue 사용 사례 - Message Queue


    public static void main(String[] args) {
        Stack<Integer> stackTest = new Stack<>();

        stackTest.add(1);
        stackTest.add(2);
        stackTest.add(3);
        stackTest.add(4);
        stackTest.add(5);
        
        int a = stackTest.pop();
        System.out.println("STACK POP : " + a); // 가장 마지막에 있는 5 값을 출력

        int b = stackTest.pop();   // pop 된 후 가장 마지막인 4 값을 출력 peek 은 사라지지 않고 확인만 함
        System.out.println("STACK PEEK : " + b);

       Queue queueTest = new PriorityQueue<Integer>();

       queueTest.add(1);
       queueTest.add(2);
       queueTest.add(3);
       queueTest.add(4);
       queueTest.add(5);
        
       int qT = (Integer) queueTest.poll();
       System.out.println("QUEUE TEST POLL : " + qT);  // Queue 는 FIFO 이므로 가장 처음에 들어간 1을 출력
       
       int qD = (Integer) queueTest.peek();
       System.out.println("QUEUE TEST PEEK : " + qD);  // 첫번쨰 값이 poll 꺼내졌으므로 그 다음 값인 2를 출력 Stack 과 마차가지로
        // poll 은 다음 값 확인만 하고 변하는 건 없음
        
        
    }
}
