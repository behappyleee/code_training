package com.my.study_toby.test;

import java.net.ServerSocket;
import java.net.Socket;

public class SocketTest {

    private static final int DEFAULT_SOCKET_PORT = 9090;

    public static void main(String[] args) {
        ServerSocket sc;
        Socket sk;

        try {
            sc = new ServerSocket(DEFAULT_SOCKET_PORT);
            sk = sc.accept();


        } catch(Exception e) {
            e.printStackTrace();
        }


    }

}
