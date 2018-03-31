package com.md.mmdo_web.web;

import org.springframework.web.bind.annotation.RequestMapping;



@org.springframework.stereotype.Controller
public class Controller {
    @RequestMapping("/hello")
    public String showHelloWorld(){
        return "hello_world";
    }
    @RequestMapping("/index1")
    public String showIndex(){
        return "index";
    }
}
