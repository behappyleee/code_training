package com.my.study_toby.test;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class HelloController {
    // This is helloController commit test
    // This is commit for merge conflict from branch_2 test

    // This is test commit for merge
    // This is commit from branch_2

    @GetMapping("/hello")
    public String getHello() {
        return "Hello World Method Check !!!";
    }

}
