package com.md.mmdo_web.web.lab1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.Scanner;

@Controller
public class Utilites {
    @RequestMapping(value="lab")
    public String lab1_init() {
        //model.addAttribute("greeting", greeting);
        //System.out.println(greeting.getId());
        return "lab1";
    }
    @RequestMapping(value="lab", method= RequestMethod.POST)
    public String resultSubmit(@RequestParam Integer[] i11, Model model) {
        model.addAttribute("i11", i11);
        //model.addAttribute("sign", sign);
        for (Integer i: i11) {
            System.out.println(i);
        }
        LinkedList<Double> results = init(i11);
           // System.out.println(sign);
        model.addAttribute("max", results.poll());
        model.addAttribute("min", results.poll());
        //System.out.println(max);
        //System.out.println(min);
        return "lab1_result";
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
    public static LinkedList<Double> init(Integer[] coefs) {
        Scanner scanner = new Scanner(System.in);
        final int line_count = 3;
        Equation mainEquation;
        LinkedList<Integer> sign = new LinkedList<Integer>();
        sign.add(0);
        sign.add(1);
        sign.add(1);
        LinkedList<Integer> coef = new LinkedList<Integer>();
        for (Integer i : coefs) {
            coef.add(i);
        }
        //System.out.println("����i�� ������� �i������");
        //System.out.println("������ ����������� ��������� �������");
        mainEquation = new Equation(coef);
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
