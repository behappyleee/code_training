package com.study.toby_spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // View 를 Reeturn 하는 것이 아니므로 API 임
    @GetMapping("/hello")
    public String hello(String name) {
        return "Hello " + name;
    }

}
