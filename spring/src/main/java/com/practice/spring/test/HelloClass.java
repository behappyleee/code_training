package com.practice.spring.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloClass {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/test")
    public String helloWorld() {
        logger.debug("Hello World This Project !");
        return "HelloWolrd";
    }


}
