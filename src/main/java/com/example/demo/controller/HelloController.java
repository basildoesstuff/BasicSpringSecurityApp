package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String Hello(){
        return "helloWorld";
    }

    @GetMapping("/bye")
    public String bye(){
        return "Get lost I said";
    }

}
