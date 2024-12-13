package com.mkyong.examples.Chapter2.VariantA;

import java.util.Scanner;

public class java9 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите коэффициенты квадратного уравнения (a, b, c): ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();

        double discriminant = b * b - 4 * a * c;

        if (discriminant < 0) {
            System.out.println("Уравнение не имеет действительных корней");
            return;
        }

        double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
        double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);

        System.out.println("Корни уравнения: " + root1 + " и " + root2);
    }
}
