package com.md.mmdo_web.controller;

import org.springframework.web.bind.annotation.RequestMapping;



@org.springframework.stereotype.Controller
public class Controller {
    @RequestMapping("/hello")
    public String showHelloWorld(){
        return "hello_world";
    }
}
