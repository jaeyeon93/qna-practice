package com.qna2.qna2.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorld {
    @GetMapping("/")
    public String helloWorld() {
        System.out.println("hello world 실행");
        return "index";
    }
}
