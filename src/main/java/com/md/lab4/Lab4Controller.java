package com.md.lab4;

import com.md.model.Size;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Component
@Controller
public class Lab4Controller {
    @RequestMapping(value = "/lab4", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView init(@ModelAttribute Size size) {
        System.out.println("Hello");
        return new ModelAndView("/lab4").addObject("size", size);
    }

    @RequestMapping(value = "/lab4_result", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView lab3_result(@ModelAttribute Size size, @RequestParam(value = "data") Integer [] coefs, Model model) {
        ModelAndView modelAndView = new ModelAndView("/lab4_result");
        model.addAttribute("size", size);
        for (Integer s: coefs) {
            System.out.println(s);
        }
        modelAndView.addObject(size);
        //Simplex simplex = new Simplex(rows,cols);
        return modelAndView;
    }
}