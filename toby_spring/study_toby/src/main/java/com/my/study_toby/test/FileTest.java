package com.my.study_toby.test;

import java.io.*;

public class FileTest {

    public static void main(String[] args) {
        File file = new File("ReadFile.txt");
        try(FileInputStream fis = new FileInputStream(file);) {
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            while(br.readLine() != null) {
                String readLine = br.readLine();
                System.out.println("READ LINE : " + readLine);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
