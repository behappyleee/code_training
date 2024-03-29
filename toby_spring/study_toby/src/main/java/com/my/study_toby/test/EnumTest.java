package com.my.study_toby.test;

import java.util.Arrays;

enum Site {
    NAVER("naver", 1),
    DAUM("daum", 2),
    NATE("nate",3);

    private String siteName;
    private int testNum;

    Site(String siteName, int test) {
        this.siteName = siteName;
        this.testNum = test;
    }

    String getSiteName() {
        return siteName;
    }

    static Site searchName(String siteName) {
        // Stream 을 사용
        return Arrays.stream(Site.values())
                .filter(s -> s.siteName.equals(siteName))
                .findAny()
                .orElse(null);
        
        // FOR 문 사용        
//        for(Site s : si) {
//            String sName = s.getSiteName();
//            if(sName.equals(siteName)) {
//                return s;
//            }
//        }
    }

}

public class EnumTest {

    public String useEnum() {

        // Enum 안에 있는 method 사용 위하여서는 무조건 static 으로 선언 ... ??/


        return null;
    }


    public static void main(String[] args) {

        Site.searchName("TEST");


    }

}
