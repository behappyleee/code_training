package com.my.study_toby.test;

public class ThreadTest {

    public static void main(String[] args) {
        ThreadEx1 tex1 = new ThreadEx1();
        tex1.start();

        ThreadEx2 tex2 = new ThreadEx2();
        Thread runTest = new Thread(tex2);
        runTest.start();

        Thread tLam = new Thread(() -> {
            System.out.println("THIS IS LAMBDA MAKE TEST THREAD !!!");
        }, "THIS IS THREAD NAME CHECK");

    }

}

class ThreadEx1 extends Thread {
    @Override
    public void run() {
        System.out.println("THIS IS THREAD OVERRIDE RUN !!!!");
    }
}

class ThreadEx2 implements Runnable {
    @Override
    public void run() {
        System.out.println("THIS IS Thread Ex2 Run Method TEST CHECK !!!!");
    }
}