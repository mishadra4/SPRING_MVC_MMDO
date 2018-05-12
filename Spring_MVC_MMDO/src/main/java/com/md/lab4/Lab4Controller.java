package com.md.lab4;

import com.md.model.Size;
import com.sun.org.apache.xpath.internal.operations.Mod;
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
    public ModelAndView init() {

        System.out.println("Hello");
        return new ModelAndView("/lab4");
    }

    @RequestMapping(value = "/lab4", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView lab4_result(@RequestParam(value = "cols") String consumers, @RequestParam(value = "rows") String providers, @RequestParam(value = "data") Integer[] coefs, @RequestParam(value = "needs") Integer[] needs, @RequestParam(value = "isPresent") Integer[] isPresent, Model model) {
        ModelAndView modelAndView = new ModelAndView("/lab4_result");
        Integer cols = Integer.parseInt(consumers);
        Integer rows = Integer.parseInt(providers);
        Result result;
        Integer[][] matr = new Integer[rows][cols];

        for (int i = 0; i < rows; i++) {
            matr[i] = new Integer[cols];
            for (int j = 0; j < cols; j++) {
                matr[i][j] = coefs[i*cols+j];
            }
        }
        SearchPlan searchPlan = new SearchPlan(cols,rows,matr, needs, isPresent);
        result = searchPlan.res();
        modelAndView.addObject("result", result);
        return modelAndView;
    }
}