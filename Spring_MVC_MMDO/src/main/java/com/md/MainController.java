package com.md;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainController {
    @RequestMapping(value = "/")
    public ModelAndView init(){
        System.out.println("Hello");

        return new ModelAndView("/index");
    }
}
