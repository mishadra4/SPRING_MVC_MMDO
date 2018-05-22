package com.md.Lab11;

import java.util.function.BiFunction;
import java.util.function.DoubleFunction;

/**
 * Created by User on 22-May-18.
 */
public class Main {
    public static void main(String[] args) {
        SingleArgumentFunctionMinimizer anotherMinimizer = new GoldenRatioMinimizer();
        //DoubleFunction<Double> f = (x) -> x * x * x + 5 * x * x - 3;
        //DoubleFunction<Double> f1 = (x) -> x*x*x - 3.14 * x * x - 1.4881488881488*x + 7;
        BiFunction<Double, Double, Double> g = (x, y) -> 4*( x * x) + 2*(y * y) - 4*x + 2*y;

        // double anotherMin = anotherMinimizer.minimize(f, 0, 3 * Math.PI, 1e-3);

        //System.out.println(anotherMin);

        DoubleArgumentFunctionMinimizer descentMinimizer = new GradientDescentMinimizer();

        Point2D res = descentMinimizer.minimize(
                g,
                new Point2D(1, 3),
                (Double x) -> x >= 0 && x <= 10,
                (Double y) -> y >= 0 && y <= 10,
                1e-2,
                1e-2);

        Point2D anotherRes = descentMinimizer.minimize(
                g,
                new Point2D(1, 3),
                (Double x) -> x >= 0 && x <= 10,
                (Double y) -> y >= 0 && y <= 10,
                1e-2);

        System.out.printf("min g = %f at point %s using constant step length\n", g.apply(res.getX(), res.getY()), res.toString());
        System.out.printf("min g = %f at point %s using variadic step length\n", g.apply(anotherRes.getX(), anotherRes.getY()), anotherRes.toString());
    }
}
