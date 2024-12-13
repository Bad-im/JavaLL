package com.mkyong.examples.Chapter3.VariantC;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<quadraticEquation> equations = Arrays.asList(
                new quadraticEquation(1, 2, 1),
                new quadraticEquation(1, -4, 4),
                new quadraticEquation(2, -3, 1),
                new quadraticEquation(3, -5, 2)
        );

        double maxRoot = Double.MIN_VALUE;
        double minRoot = Double.MAX_VALUE;
        for (quadraticEquation equation : equations) {
            double[] roots = equation.findRoots();
            if (roots.length > 0) {
                for (double root : roots) {
                    maxRoot = Math.max(maxRoot, root);
                    minRoot = Math.min(minRoot, root);
                }
            }
        }

        System.out.println("Наибольший корень: " + maxRoot);
        System.out.println("Наименьший корень: " + minRoot);

        for (quadraticEquation equation : equations) {
            double vertex = equation.findVertex();
            double valueAtVertex = equation.findValueAtVertex();
            String intervals = equation.findIntervals();
            System.out.println("Уравнение: " + equation);
            System.out.println("Вершина: (" + vertex + ", " + valueAtVertex + ")");
            System.out.println("Интервалы убывания/возрастания: " + intervals);
            System.out.println();
        }
    }
}

class quadraticEquation {
    private double a;
    private double b;
    private double c;

    public quadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double[] findRoots() {
        double discriminant = b * b - 4 * a * c;
        if (discriminant < 0) {
            return new double[0];
        } else if (discriminant == 0) {
            return new double[]{-b / (2 * a)};
        } else {
            return new double[]{(-b + Math.sqrt(discriminant)) / (2 * a), (-b - Math.sqrt(discriminant)) / (2 * a)};
        }
    }

    public double findVertex() {
        return -b / (2 * a);
    }

    public double findValueAtVertex() {
        double vertex = findVertex();
        return a * vertex * vertex + b * vertex + c;
    }

    public String findIntervals() {
        double vertex = findVertex();
        if (a > 0) {
            return "Убывает на (-∞; " + vertex + ") и возрастает на (" + vertex + "; +∞)";
        } else if (a < 0) {
            return "Возрастает на (-∞; " + vertex + ") и убывает на (" + vertex + "; +∞)";
        } else {
            return "Уравнение не является квадратным";
        }
    }

    @Override
    public String toString() {
        return "Квадратное уравнение: " + a + "x^2 + " + b + "x + " + c;
    }
}
