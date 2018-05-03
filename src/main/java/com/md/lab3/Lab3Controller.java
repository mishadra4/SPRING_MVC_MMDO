package com.md.lab3;

import com.md.model.Size;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Component
@Controller
public class Lab3Controller {
    @RequestMapping(value = "/lab3", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView init(@ModelAttribute Size size) {
        System.out.println("Hello");
        return new ModelAndView("/lab3").addObject("user", size);
    }

    @RequestMapping(value = "/lab3_result", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView lab3_result(@ModelAttribute Size size, @RequestParam(value = "data") Integer [] coefs, Model model) {
        ModelAndView modelAndView = new ModelAndView("/lab3_result");
        model.addAttribute("user", size);
        for (Integer s: coefs) {
            System.out.println(s);
        }
        modelAndView.addObject(size);
        //Simplex simplex = new Simplex(rows,cols);
        return modelAndView;
    }
}