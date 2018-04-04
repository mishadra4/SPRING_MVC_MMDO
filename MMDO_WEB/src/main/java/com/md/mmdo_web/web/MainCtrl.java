package com.md.mmdo_web.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;


@Controller
public class MainCtrl {
    @RequestMapping("/hello")
    public String showHelloWorld(){
        return "hello_world";
    }
    @RequestMapping("/index1")
    public String showIndex(){
        return "index";
    }
}
