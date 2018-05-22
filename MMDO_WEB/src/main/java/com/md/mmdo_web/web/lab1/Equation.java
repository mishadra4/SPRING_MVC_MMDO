package com.md.mmdo_web.web.lab1;



import java.util.Queue;
import java.util.Scanner;

public class Equation {
    Scanner scanner = new Scanner(System.in);
    private double a;
    private double b;
    private double c;
    private int sign;// 1 - >=   0 -  <=

    public Equation(Queue<Integer> coef){
        a = coef.poll();
        b = coef.poll();
        c = coef.poll();
    }

    double CalculateFunction(Point point){
        return point.getX()*a + point.getY()*b - c;   // ax+by-c=
    }
    Point GetPoinIntersection(Equation obj) { // повертaє точку перетину 2 прямих
        double del, del_x, del_y;
        double a2, b2, c2;
        a2 = obj.a;
        b2 = obj.b;
        c2 = obj.c;
        del = a*b2 - b*a2;
        del_x = c*b2 - b*c2;
        del_y = a*c2 - c*a2;
        Point temp = new Point();
        temp.setX(del_x / del);
        temp.setY(del_y / del);
        return temp;
    }
    public static boolean check(Point point, Equation obj){
        double F, z;
        F = obj.CalculateFunction(point);
        z = obj.sign;//z >= 1           <= 0
        if (point.getX()<0 || point.getY()<0)
            return false;
        if (z == 1){
            if (F >= 0)
                return true;
            else
                return false;
        }
        if (z == 0){
            if (F <= 0)
                return true;
            else
                return false;
        }
        return false;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public int getSign() {
        return sign;
    }

    public void setSign(int sign) {
        this.sign = sign;
    }
}
