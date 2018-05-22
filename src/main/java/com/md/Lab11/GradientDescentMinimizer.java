package com.md.Lab11;


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class GradientDescentMinimizer implements DoubleArgumentFunctionMinimizer {
    private final double EPS = 1e-1;

    /*
        ћетод градиентного спуска. ќснован на утверждении, что градиент, вз€тый со знаком минус
        показывает направление скорейшего убывани€ функции. —оответственно, шага€ из заданной начальной точки
        вдоль этого направлени€ рано или поздно мы придем в точку минимума. ¬ данном случае, мы выбираем величину шага
        равной некоторой константе. ƒва предиката в параметрах функции - это ограничени€ дл€ икса и игрека.
        (мы ищем минимум в некоторой области). ”слови€ остановки алгоритма - либо разность значений функции меньше
        заданной точности, либо нова€ точка отстоит от старой точки на рассто€ние, меньшее той же точности, либо же
        нова€ точка вышла за пределы области, в которой мы ищем минимум.
     */

    @Override
    public Point2D minimize(BiFunction<Double, Double, Double> f,
                            Point2D startPoint,
                            Predicate<Double> domX,
                            Predicate<Double> domY,
                            double precision,
                            double stepSize) {
        try {
            Point2D nextPoint = new Point2D();

            int gradientComputationsCounter = 0;
            int functionComputationsCounter = 0;
            PrintWriter writer = null;

            writer = new PrintWriter("GradientDescentMinimizerOut1.txt");


            for (;;) {
                Point2D grad = getGradient(f, startPoint);

                gradientComputationsCounter++;
                nextPoint = Point2D.sub(startPoint, Point2D.mul(grad, stepSize));

                Boolean stopCriteria1 = getNorm(Point2D.sub(nextPoint, startPoint)) < precision;
                Boolean stopCriteria2 = !domX.test(nextPoint.getX());
                Boolean stopCriteria3 = !domY.test(nextPoint.getY());
                Boolean stopCriteria4 = Math.abs(f.apply(nextPoint.getX(), nextPoint.getY()) - f.apply(startPoint.getX(), startPoint.getY())) < precision;
                functionComputationsCounter++;

                writer.format("%s -> %.5f\n", startPoint.toString(), f.apply(startPoint.getX(), startPoint.getY()));

                if (stopCriteria1 || stopCriteria2 || stopCriteria3 || stopCriteria4) {
                    writer.format("I calculated gradient for %d times, and function for %d times", gradientComputationsCounter, functionComputationsCounter);
                    writer.close();
                    return nextPoint;
                }

                startPoint = new Point2D(nextPoint.getX(), nextPoint.getY());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
        ¬ерси€ градиентного спуска, в которой длина шага считаетс€ на каждом этапе. Ѕудем считать
        ее из вот такого соображени€: пусть длина шага будет такой, что функци€ f( xi - lambda * grad( f(xi) ) )
        “о есть, шага€ вдоль направлени€ антиградиента, мы хотим прийти в точку минимума на этом луче. ¬ данном
        случае придетс€ на каждом шаге решать задачу одномерной оптимизации. ћы воспользуемс€ методом золотого сечени€
        ”слови€ остановки алгоритма - те же, что и выше
     */

    @Override
    public Point2D minimize(BiFunction<Double, Double, Double> f,
                            Point2D startPoint,
                            Predicate<Double> domX,
                            Predicate<Double> domY,
                            double precision) {
        try {
            Point2D nextPoint = new Point2D();
            GoldenRatioMinimizer goldenRatioMinimizer = new GoldenRatioMinimizer();
            int gradientComputationsCounter = 0;
            int functionComputationsCounter = 0;
            PrintWriter writer = new PrintWriter("GradientDescentMinimizerOut2.txt");
            for (;;) {
                Point2D grad = getGradient(f, startPoint);
                gradientComputationsCounter++;
                final Point2D finalStartPoint = startPoint;
                double stepSize = goldenRatioMinimizer.argmin(
                        (x) -> {
                            Point2D point = Point2D.sub(finalStartPoint, Point2D.mul(grad, x));
                            return f.apply(point.getX(), point.getY());
                        },
                        0.0,
                        1.0,
                        1e-2);

                nextPoint = Point2D.sub(startPoint, Point2D.mul(grad, stepSize));
                writer.format("%s -> %.5f\n", startPoint.toString(), f.apply(startPoint.getX(), startPoint.getY()));

                Boolean stopCriteria1 = getNorm(Point2D.sub(nextPoint, startPoint)) < precision;
                Boolean stopCriteria2 = !domX.test(nextPoint.getX());
                Boolean stopCriteria3 = !domY.test(nextPoint.getY());
                Boolean stopCriteria4 = Math.abs(f.apply(nextPoint.getX(), nextPoint.getY()) - f.apply(startPoint.getX(), startPoint.getY())) < precision;
                functionComputationsCounter++;
                if (stopCriteria1 || stopCriteria2 || stopCriteria3 || stopCriteria4) {
                    writer.format("I calculated gradient for %d times, and function for %d times", gradientComputationsCounter, functionComputationsCounter);
                    writer.close();
                    return nextPoint;
                }
                startPoint = new Point2D(nextPoint.getX(), nextPoint.getY());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
        ¬спомогательна€ функци€ дл€ подсчета градиента. „астные производные в заданной точке считаютс€ численно.
        Ќапример, частна€ производна€ по иксу считаетс€ следующим образом: берем точку (x,y), к иксу прибавл€ем
        маленькое эпсилон, получаем точку (x + eps, y). —читаем разность между значени€ми функции в этих двух
        точках и делим на эпсилон. ƒл€ игрека все то же самое, только фиксируем значение икса.
     */

    private Point2D getGradient(BiFunction<Double, Double, Double> f, Point2D point) {
        double x = (f.apply(point.getX() + EPS, point.getY()) - f.apply(point.getX(), point.getY())) / EPS;
        double y = (f.apply(point.getX(), point.getY() + EPS) - f.apply(point.getX(), point.getY())) / EPS;
        return new Point2D(x, y);
    }

    private double getNorm(Point2D point) {
        return Math.sqrt( ( point.getX() * point.getX() ) + ( point.getY() * point.getY() ) );
    }
}
