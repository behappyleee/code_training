package com.my.study_toby.test;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // This is helloController commit test
    // This is commit for merge conflict from branch_2 test


    @GetMapping("/hello")
    public String getHello() {
        return "Hello World Method Check !!!";
    }

}
