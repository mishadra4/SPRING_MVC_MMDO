package com.md.lab1;

import com.md.model.Size;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;

@Controller
public class Lab1Controller {

    @RequestMapping(value = "/lab1", method = RequestMethod.GET)
    public ModelAndView init(@ModelAttribute Size size) {
        System.out.println("Hello");
        return new ModelAndView("/lab1").addObject("user", size);
    }
    @RequestMapping(value="/lab1", method= RequestMethod.POST)
    @ResponseBody
    public ModelAndView resultSubmit(@ModelAttribute Size size, @RequestParam Integer[] data, @RequestParam Integer[] sign, @RequestParam Integer[] main) {
        ModelAndView modelAndView = new ModelAndView("/lab1_result");
        for (Integer i : data) {
            System.out.println(i);
        }
        for (Integer i : sign) {
            System.out.println(i);
        }
        for (Integer i: main) {
            System.out.println(i);
        }
        LinkedList<Double> results = init(data, sign, main);
        modelAndView.addObject("max",results.poll());
        modelAndView.addObject("min",results.poll());
        return modelAndView;
    }
    public static int factorial(int number){
        if(number == 0){
            return 1;
        }
        int factorial = 1;
        for (int i = number; i > 1; i--) {
            factorial *= number;
        }
        return factorial;
    }
    public static LinkedList<Double> init(Integer[] coefs, Integer[] signs, Integer[] main) {
        final int line_count = 3;
        Equation mainEquation;
        LinkedList<Integer> sign = new LinkedList<Integer>();
        for (Integer i: signs) {
            sign.add(i);
        }
        LinkedList<Integer> coef = new LinkedList<Integer>();
        for (Integer i : coefs) {
            coef.add(i);
        }
        LinkedList<Integer> mainC = new LinkedList<Integer>();
        for (Integer i : main) {
            mainC.add(i);
        }
        mainC.add(0);

        //System.out.println("����i�� ������� �i������");
        //System.out.println("������ ����������� ��������� �������");
        mainEquation = new Equation(mainC);
        //System.out.println("����i�� �i���i��� ���i�������");
        //line_count = scanner.nextInt();
        Equation [] equations = new Equation[line_count];
        //int z;
        for (int i = 0; i<line_count; i++){
            //System.out.println( "����i�� ����i�i���� " + (i + 1) + " ���i�����i");
            equations[i] = new Equation(coef);
            //System.out.println("�����i�� ���� ���i�����i >= -  1,  <=  - 0");
            //z = scanner.nextInt();
            equations[i].setSign(sign.poll());
        }
        int point_count = factorial(line_count);
        Point[] arr = new Point[line_count + point_count];// ����� ����� ��������
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Point();
        }
        int i = 0;
        while (i<line_count * 2){ // ������� � ��� �� � ��  x =0   ;  y= 0
            arr[i].setX(0);
            arr[i].setY(equations[i / 2].getC() / equations[i / 2].getB());

            i++;

            arr[i].setY(0);
            arr[i].setX(equations[i / 2].getC() / equations[i / 2].getA());
            i++;
        }
        for (int line1 = 0; line1<line_count; line1++){			// ��������� ����� �������� ������
            for (int line2 = line1 + 1; line2<line_count; line2++){
                arr[i] = equations[line1].GetPoinIntersection(equations[line2]);
                i++;
            }
        }

        for (int j = 0; j<i; j++){			// ��������� ����� �� ������� � �������
            int key = 0;
            for (int k = 0; k<line_count; k++){
                if (Equation.check(arr[j], equations[k]) == false){
                    key++;
                    break;
                }
            }
            if (key>0){
                for (int v = j; v<i - 1; v++)//���� ����� �� ������� � ������� �� �� ���������
                    arr[v] = arr[v + 1];//������� ����� ������
                i--;

                j--;

            }
        }

        double min = 0, max = 0, Func;
        max = mainEquation.CalculateFunction(arr[0]); // ��������� ����� � ��������
        for (int j = 1; j<i; j++){
            Func = mainEquation.CalculateFunction(arr[j]);
            if (Func>max)
                max = Func;
            if (j == 1)
                min = Func;
            if (Func<min)
                min = Func;
        }
        LinkedList<Double> results = new LinkedList<Double>();
        results.add(max);
        results.add(min);
        System.out.println("max= " + max + " min= " + min);
        //System.out.println("������� ������� ����� ��-210 ���� �������");
        return results;
    }
}
